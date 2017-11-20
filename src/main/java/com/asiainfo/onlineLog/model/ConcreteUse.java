package com.asiainfo.onlineLog.model;

/**
 * Created by admin on 2017/11/17.
 */
public class ConcreteUse {

    /**
     *
     */
    private String busiId;

    /**
     *
     */
    private String groupCount;

    /**
     *
     */
    private String aliasFlow;

    /**
     *
     */
    private String appExtFlag;

    /**
     *
     */
    private String maxTime;

    /**
     *
     */
    private String minTime;

    /**
     *
     */
    private String termModelId;

    /**
     *
     */
    private String termModelCode;

    public ConcreteUse() {
    }

    public ConcreteUse(String busiId, String groupCount, String aliasFlow, String appExtFlag, String maxTime, String minTime, String termModel, String termModelCode) {
        this.busiId = busiId;
        this.groupCount = groupCount;
        this.aliasFlow = aliasFlow;
        this.appExtFlag = appExtFlag;
        this.maxTime = maxTime;
        this.minTime = minTime;
        this.termModelId = termModel;
        this.termModelCode = termModelCode;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(String groupCount) {
        this.groupCount = groupCount;
    }

    public String getAliasFlow() {
        return aliasFlow;
    }

    public void setAliasFlow(String aliasFlow) {
        this.aliasFlow = aliasFlow;
    }

    public String getAppExtFlag() {
        return appExtFlag;
    }

    public void setAppExtFlag(String appExtFlag) {
        this.appExtFlag = appExtFlag;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public String getMinTime() {
        return minTime;
    }

    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }

    public String getTermModelId() {
        return termModelId;
    }

    public void setTermModelId(String termModelId) {
        this.termModelId = termModelId;
    }

    public String getTermModelCode() {
        return termModelCode;
    }

    public void setTermModelCode(String termModelCode) {
        this.termModelCode = termModelCode;
    }
}
