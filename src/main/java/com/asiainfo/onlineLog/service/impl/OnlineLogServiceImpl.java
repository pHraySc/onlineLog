package com.asiainfo.onlineLog.service.impl;

import com.asiainfo.onlineLog.dao.IOnlineLogDao;
import com.asiainfo.onlineLog.model.ConcreteUse;
import com.asiainfo.onlineLog.service.IOnlineLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/11/17.
 */
@Service
public class OnlineLogServiceImpl implements IOnlineLogService {


    @Autowired
    IOnlineLogDao onlineLogDao;


    /**
     * 根据电话号码获取具体信息
     *
     * @param phoneNo, startTime, endTime
     * @return List
     */
    @Override
    public List<ConcreteUse> queryCompGprsBillInfo(String phoneNo, String startTime, String endTime) {

        return onlineLogDao.queryCompGprsBillInfo(phoneNo, startTime, endTime);

    }
}
