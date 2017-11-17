package com.asiainfo.onlineLog.model;

/**
 * Created by admin on 2017/11/17.
 */
public class ConcreteUse {

    /**
     *
     */
    private String groupRecordCount;

    /**
     *
     */
    private String groupValueName;

    /**
     *
     */
    private String groupTotalFlow;

    /**
     *
     */
    private String groupValue;

    /**
     *
     */
    private String appFlag;

    /**
     *
     */
    private String termName;

    /**
     *
     */
    private String timeRange;

    /**
     *
     */
    private String groupDetail;

    public ConcreteUse() {
    }

    public ConcreteUse(String groupRecordCount, String groupValueName, String groupTotalFlow, String groupValue, String appFlag, String termName, String timeRange, String groupDetail) {
        this.groupRecordCount = groupRecordCount;
        this.groupValueName = groupValueName;
        this.groupTotalFlow = groupTotalFlow;
        this.groupValue = groupValue;
        this.appFlag = appFlag;
        this.termName = termName;
        this.timeRange = timeRange;
        this.groupDetail = groupDetail;
    }

    public String getGroupRecordCount() {
        return groupRecordCount;
    }

    public void setGroupRecordCount(String groupRecordCount) {
        this.groupRecordCount = groupRecordCount;
    }

    public String getGroupValueName() {
        return groupValueName;
    }

    public void setGroupValueName(String groupValueName) {
        this.groupValueName = groupValueName;
    }

    public String getGroupTotalFlow() {
        return groupTotalFlow;
    }

    public void setGroupTotalFlow(String groupTotalFlow) {
        this.groupTotalFlow = groupTotalFlow;
    }

    public String getGroupValue() {
        return groupValue;
    }

    public void setGroupValue(String groupValue) {
        this.groupValue = groupValue;
    }

    public String getAppFlag() {
        return appFlag;
    }

    public void setAppFlag(String appFlag) {
        this.appFlag = appFlag;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getGroupDetail() {
        return groupDetail;
    }

    public void setGroupDetail(String groupDetail) {
        this.groupDetail = groupDetail;
    }
}
