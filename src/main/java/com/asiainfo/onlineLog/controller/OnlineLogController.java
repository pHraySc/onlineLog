package com.asiainfo.onlineLog.controller;

import com.asiainfo.onlineLog.model.Result;
import com.asiainfo.onlineLog.service.IOnlineLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2017/11/16.
 */
@Controller
@RequestMapping("/tas/aibi_tas/comp")
public class OnlineLogController {

    private static final Logger logger = LoggerFactory.getLogger(OnlineLogController.class);

    @Autowired
    private IOnlineLogService onlineLogService;

    @ResponseBody
    @GetMapping("/compGprsBill")
    public Result test(@RequestParam(value = "charge_id") String chargeId,
                       @RequestParam(value = "ailk_autoLogin_userId") String ailkAutoLoginUserId,
                       @RequestParam(value = "phoneNo") String phoneNo,
                       @RequestParam(value = "startTime") String startTime,
                       @RequestParam(value = "endTime") String endTime,
                       @RequestParam(value = "flow", defaultValue = "0") String flow,
                       @RequestParam(value = "billNo") String billNo) {

        return null;

    }
}
