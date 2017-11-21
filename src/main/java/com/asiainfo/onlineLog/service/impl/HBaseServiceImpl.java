package com.asiainfo.onlineLog.service.impl;

import com.asiainfo.onlineLog.model.ConcreteUse;
import com.asiainfo.onlineLog.service.IHBaseService;
import com.asiainfo.onlineLog.util.MD5RowKeyGenerator;
import com.asiainfo.onlineLog.util.TabOnloadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/11/20.
 */
@Service
public class HBaseServiceImpl implements IHBaseService {

    @Autowired
    @Qualifier("connect")
    private Connection connection;

    private final Logger logger = LoggerFactory.getLogger(HBaseServiceImpl.class);


    /**
     * 根据电话号码获取具体信息
     *
     * @param phoneNo, startTime, endTime
     * @return List
     */
    @Override
    public Map<String,ConcreteUse> queryCompGprsBillInfo(String phoneNo, String startTime, String endTime) {

        String sql;
        String month1 = startTime.substring(0, 6);
        String month2 = startTime.substring(0, 6);

        String md5PhoneNo = new MD5RowKeyGenerator().generatePrefix(phoneNo);
        StringBuffer str1 = new StringBuffer();
        String idStart = str1.append(md5PhoneNo).append(phoneNo).append(startTime).toString();

        StringBuffer str2 = new StringBuffer();
        String idEnd = str2.append(md5PhoneNo).append(phoneNo).append(endTime).toString();


        if (month1.equals(month2)) {

            sql = "select BUSI_ID, count(BUSI_ID) as GROUPCOUNT, SUM(TO_NUMBER(FLOW)/1024/1024) as ALIASFLOW," +
                    " MAX(APP_EXT_FLAG) as APPEXTFLAG," + "MAX(END_TIME) as MAXTIME, MIN(END_TIME) as MINTIME, " +
                    " MAX(TERM_MODEL_ID) as TERMMODELID " +
                    " MAX(TERM_MODEL_CODE) as TERMMODELCODE \n" +
                    "from CD_GPRS_" + month1 + " where  ID>= '" + idStart + "' and ID<= '" + idEnd + "' group by BUSI_ID";
        } else {

            StringBuffer str3 = new StringBuffer();
            String month3 = LocalDate.parse(month1 + "01", DateTimeFormatter.ofPattern("yyyyMMdd")).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String idEnd1 = str3.append(md5PhoneNo).append(phoneNo).append(month3 + "235959").toString();

            String month4 = month2 + "01000000";

            String idStart1 = str3.append(md5PhoneNo).append(phoneNo).append(month4).toString();

            sql = "select BUSI_ID, count(BUSI_ID) as GROUPCOUNT, SUM(TO_NUMBER(FLOW)/1024/1024) as ALIASFLOW, MAX(APP_EXT_FLAG) as APPEXTFLAG, " +
                    " MAX(END_TIME) as MAXTIME, MIN(END_TIME) as MINTIME, MAX(TERM_MODEL_ID) as TERMMODELID " +
                    " MAX(TERM_MODEL_CODE) as TERMMODELCODE from \n" +
                    "(select * from CD_GPRS_" + month1 + " where  ID>= '" + idStart + "' and ID<= '" + idEnd1 +
                    "' union all" +
                    "select * from CD_GPRS_" + month2 + " where  ID> '" + idStart1 + "' and ID<= '" + idEnd + "' ) a group BY BUSI_ID";
        }
        logger.info("============================查询========================");
        logger.info(sql);
        PreparedStatement pst;
        ResultSet rs;
        ConcreteUse concreteUse;
        Map<String,ConcreteUse> concreteUseMap = new HashMap<String,ConcreteUse>();
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                concreteUse = new ConcreteUse();

                concreteUse.setBusiId(rs.getString("BUSIID"));

                String[] busiVal = String.valueOf(TabOnloadUtil.tasApplicationMap.get(concreteUse.getBusiId())).split("&");

                if (concreteUseMap.containsKey(busiVal[0])) {

                    ConcreteUse a = concreteUseMap.get(busiVal[0]);
                    a.setGroupCount(String.valueOf(Integer.parseInt(a.getGroupCount()) + Integer.parseInt(rs.getString("GROUPCOUNT"))));
                    a.setAliasFlow(String.valueOf(Float.parseFloat(a.getAliasFlow()) + Float.parseFloat(rs.getString("ALIASFLOW"))));

                } else {

                    concreteUse.setBusiName(busiVal[0]);
                    concreteUse.setAppType(busiVal[1]);
                    concreteUse.setExplain(busiVal[2]);
                    concreteUse.setGroupCount(rs.getString("GROUPCOUNT"));
                    concreteUse.setAliasFlow(rs.getString("ALIASFLOW"));
                    concreteUse.setAppExtFlag(rs.getString("APPEXTFLAG"));
                    concreteUse.setMaxTime(rs.getString("MAXTIME"));
                    concreteUse.setMinTime(rs.getString("MINTIME"));
                    concreteUse.setTermModelId(rs.getString("TERMMODELID"));
                    concreteUse.setTermModelCode(rs.getString("TERMMODELCODE"));
                    concreteUseMap.put(busiVal[0],concreteUse);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return concreteUseMap;

    }
}
