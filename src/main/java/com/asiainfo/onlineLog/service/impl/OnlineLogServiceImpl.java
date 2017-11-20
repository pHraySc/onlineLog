package com.asiainfo.onlineLog.service.impl;

import com.asiainfo.onlineLog.dao.IOnlineLogDao;
import com.asiainfo.onlineLog.service.IOnlineLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/11/17.
 */
@Service
public class OnlineLogServiceImpl implements IOnlineLogService {


    @Autowired
    IOnlineLogDao onlineLogDao;


}
