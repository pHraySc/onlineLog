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


        String sql = "select * from CD_GPRS_" + month
                + " where id>'" + start + "' and id<'" + end + "' and busi_id in('" + busi_id.replaceAll("\\|", "','") + "')";
        logger.info("============================查询========================");
        logger.info(sql);
        PreparedStatement pst = null;
        ResultSet rs = null;
        JSONObject json = null;
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            json = new JSONObject();
            json.put("phone_no", phone_no);
            json.put("date", date);
            JSONArray ja = new JSONArray();
            JSONObject job = null;
            while (rs.next()) {
                job = new JSONObject();
                job.put("busi_id", rs.getString("busi_id"));
                job.put("flow", rs.getString("flow"));
                job.put("start_time", rs.getString("start_time"));
                job.put("end_time", rs.getString("end_time"));
                job.put("url", rs.getString("acce_url"));
                ja.put(job);
            }
            json.put("data", ja);
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return null;

    }
}
