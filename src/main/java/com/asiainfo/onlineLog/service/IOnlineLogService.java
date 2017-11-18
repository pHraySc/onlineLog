package com.asiainfo.onlineLog.service;

import com.asiainfo.onlineLog.model.ConcreteUse;

import java.util.List;

/**
 * Created by admin on 2017/11/17.
 */
public interface IOnlineLogService {

    /**
     * 根据电话号码获取具体信息
     *
     * @param phoneNo, startTime, endTime
     * @return List
     */
    List<ConcreteUse> queryCompGprsBillInfo(String phoneNo, String startTime, String endTime);
}
