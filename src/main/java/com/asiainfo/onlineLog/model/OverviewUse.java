package com.asiainfo.onlineLog.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by admin on 2017/11/17.
 */
public class OverviewUse {

    /**
     * 电话号
     */
    @NotBlank(message = "手机号不能为空!")
    private String phoneNo;

    /**
     * 用户登录id
     */
    @NotBlank(message = "用户登录id不能为空!")
    private String loginUserId;

    /**
     * 开始时间
     */
    @NotBlank(message = "开始时间不能为空!")
    private String startTime;

    /**
     * 结束时间
     */
    @NotBlank(message = "结束时间不能为空!")
    private String endTime;

    /**
     *
     */
    @NotBlank(message = "billNo不能为空!")
    private String billNo;

    /**
     *
     */
    @NotBlank(message = "billNo不能为空!")
    private String chargeId;

    /**
     * 流量值：单位MB
     */
    private String flow = "4E97A6973C19755C";

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public OverviewUse(String phoneNo, String loginUserId, String startTime, String endTime, String billNo, String chargeId, String flow) {
        this.phoneNo = phoneNo;
        this.loginUserId = loginUserId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.billNo = billNo;
        this.chargeId = chargeId;
        this.flow = flow;
    }

    public OverviewUse() {
    }
}
