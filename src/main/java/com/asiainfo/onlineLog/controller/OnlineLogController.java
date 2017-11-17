package com.asiainfo.onlineLog.controller;

import com.asiainfo.biframe.utils.string.DES;
import com.asiainfo.onlineLog.model.Result;
import com.asiainfo.onlineLog.service.IOnlineLogService;
import com.asiainfo.onlineLog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by admin on 2017/11/16.
 */
@Controller
@RequestMapping("/tas/aibi_tas/comp")
public class OnlineLogController {

    private static Logger logger = LoggerFactory.getLogger(OnlineLogController.class);

    @Autowired
    private IOnlineLogService onlineLogService;

    @ResponseBody
    @GetMapping("/compGprsBill")
    public Result test(@RequestParam(value = "charge_id") String chargeId,
                       @RequestParam(value = "ailk_autoLogin_userId", defaultValue = "") String ailkAutoLoginUserId,
                       @RequestParam(value = "phoneNo") String phoneNo,
                       @RequestParam(value = "startTime") String startTime,
                       @RequestParam(value = "endTime") String endTime,
                       @RequestParam(value = "flow", defaultValue = "0") String flow,
                       @RequestParam(value = "billNo") String billNo) {

        String ailkAutoLoginUserId1 = null;
        String phoneNo1 = null;
        String startTime1 = null;
        String endTime1 = null;
        String billNo1 = null;
        String chargeId1 = null;
        String flow1 = null;

        try {

            ailkAutoLoginUserId1 = DES.decrypt(ailkAutoLoginUserId);
            phoneNo1 = DES.decrypt(phoneNo);
            startTime1 = DES.decrypt(startTime);
            endTime1 = DES.decrypt(endTime);
            billNo1 = DES.decrypt(billNo);
            chargeId1 = DES.decrypt(chargeId);
            flow1 = DES.decrypt(flow);

        } catch (Exception e) {

            e.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put("ailkAutoLoginUserId1", ailkAutoLoginUserId1);
        map.put("phoneNo1", phoneNo1);
        map.put("startTime1", startTime1);
        map.put("endTime1", endTime1);
        map.put("billNo1", billNo1);
        map.put("chargeId1", chargeId1);
        map.put("flow1", flow1);

        return ResultUtil.success(map);

    }
}
