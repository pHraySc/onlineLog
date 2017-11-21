package com.asiainfo.onlineLog.service;

import com.asiainfo.onlineLog.model.TasApproveExp;

import java.util.Map;

/**
 * Created by admin on 2017/11/17.
 */
public interface IOnlineLogService {

    Map queryReasonInfo();

    void saveReansonInfo(TasApproveExp tasApproveExp);
}
