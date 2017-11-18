package com.asiainfo.onlineLog.controller;

import com.asiainfo.biframe.utils.string.DES;
import com.asiainfo.onlineLog.model.ConcreteUse;
import com.asiainfo.onlineLog.model.OverviewUse;
import com.asiainfo.onlineLog.model.Result;
import com.asiainfo.onlineLog.service.IOnlineLogService;
import com.asiainfo.onlineLog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

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
    public Result test(@RequestBody @Valid OverviewUse overviewUse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        String loginUserId1 = null;
        String phoneNo1 = null;
        String startTime1 = null;
        String endTime1 = null;
        String billNo1 = null;
        String chargeId1 = null;
        String flow1 = null;

        try {

            phoneNo1 = DES.decrypt(overviewUse.getPhoneNo());
            loginUserId1 = DES.decrypt(overviewUse.getLoginUserId());
            startTime1 = DES.decrypt(overviewUse.getStartTime());
            endTime1 = DES.decrypt(overviewUse.getEndTime());
            billNo1 = DES.decrypt(overviewUse.getBillNo());
            chargeId1 = DES.decrypt(overviewUse.getChargeId());
            flow1 = DES.decrypt(overviewUse.getFlow());

        } catch (Exception e) {

            e.printStackTrace();
        }

        HashMap map = new HashMap();

        OverviewUse overviewUse1 = new OverviewUse(phoneNo1, loginUserId1, startTime1, endTime1, billNo1, chargeId1, flow1);

        map.put("overviewUse1", overviewUse1);

        return ResultUtil.success(map);

    }

    @ResponseBody
    @GetMapping("/compGprsBillInfo")
    public Result queryCompGprsBillInfo(@RequestParam(value = "phoneNo") String phoneNo,
                                        @RequestParam(value = "startTime") String startTime,
                                        @RequestParam(value = "endTime") String endTime) {

        String startTime1 = startTime.replaceAll("[^\\d]", "");
        String endTime1 = endTime.replaceAll("[^\\d]", "");

        List<ConcreteUse> concreteUseList = onlineLogService.queryCompGprsBillInfo(phoneNo, startTime1, endTime1);
        return ResultUtil.success();
    }
}
