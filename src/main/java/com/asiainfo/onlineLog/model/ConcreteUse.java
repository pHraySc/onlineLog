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

    /**
     *
     */
    private String busiName;

    /**
     *
     */
    private String appType;

    /**
     *
     */
    private String explain;

    /**
     *
     */
    private String percent;


    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

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
