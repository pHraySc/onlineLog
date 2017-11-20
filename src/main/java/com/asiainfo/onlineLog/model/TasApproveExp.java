package com.asiainfo.onlineLog.model;

/**
 * Created by admin on 2017/11/20.
 */
public class TasApproveExp {

    private String Id;

    private String situation;

    private String reason;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
