package com.asiainfo.onlineLog.service.impl;

import com.asiainfo.onlineLog.dao.IOnlineLogDao;
import com.asiainfo.onlineLog.model.TasApproveExp;
import com.asiainfo.onlineLog.service.IOnlineLogService;
import com.asiainfo.onlineLog.util.TabOnloadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by admin on 2017/11/17.
 */
@Service
public class OnlineLogServiceImpl implements IOnlineLogService {


    @Autowired
    IOnlineLogDao onlineLogDao;


    @Override
    public Map queryReasonInfo() {
        return TabOnloadUtil.tasApproveExpMap;
    }

    @Override
    public void saveReansonInfo(TasApproveExp tasApproveExp) {

    }
}
