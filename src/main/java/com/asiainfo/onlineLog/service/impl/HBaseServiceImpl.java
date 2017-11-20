package com.asiainfo.onlineLog.service.impl;

import com.asiainfo.onlineLog.model.ConcreteUse;
import com.asiainfo.onlineLog.service.IHBaseService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<ConcreteUse> queryCompGprsBillInfo(String phoneNo, String startTime, String endTime) {


        String month = startTime.substring(0, 6);

        String sql = null;
        logger.info("============================查询========================");
        logger.info(sql);
        PreparedStatement pst = null;
        ResultSet rs = null;
        JSONObject json = null;
        ConcreteUse concreteUse;
        List<ConcreteUse> concreteUseList = new ArrayList<ConcreteUse>();
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                concreteUse = new ConcreteUse();

                concreteUse.setAppFlag(rs.getString("appFlag"));
                concreteUse.setGroupRecordCount(rs.getString("groupRecordCount"));
                concreteUse.setGroupValueName(rs.getString("groupValueName"));
                concreteUse.setGroupTotalFlow(rs.getString("groupTotalFlow"));
                concreteUse.setGroupValue(rs.getString("groupValue"));
                concreteUse.setAppFlag(rs.getString("appFlag"));
                concreteUse.setTermName(rs.getString("termName"));
                concreteUse.setTimeRange(rs.getString("timeRange"));
                concreteUse.setGroupDetail(rs.getString("groupDetail"));

                concreteUseList.add(concreteUse);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return concreteUseList;

    }
}
