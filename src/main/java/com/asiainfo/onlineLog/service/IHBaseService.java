package com.asiainfo.onlineLog.service;

import com.asiainfo.onlineLog.model.ConcreteUse;

import java.util.Map;

/**
 * Created by admin on 2017/11/20.
 */
public interface IHBaseService {

    /**
     * 根据电话号码获取具体信息
     *
     * @param phoneNo, startTime, endTime
     * @return List
     */
    public Map<String, ConcreteUse> queryCompGprsBillInfo(String phoneNo, String startTime, String endTime);
}
