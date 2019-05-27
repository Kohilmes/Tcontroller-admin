package com.foxcii.tcontroller.entity;

import java.util.Date;

public class employ {
    private Integer employid;

    private String employInfo;

    private String employImg;

    private Date employTime;

    private String employStatus;

    private String employAddress;

    private Integer userid;

    private Integer fixid;

    public String getEmployAddress() {
        return employAddress;
    }

    public void setEmployAddress(String employAddress) {
        this.employAddress = employAddress;
    }

    public Integer getEmployid() {
        return employid;
    }

    public void setEmployid(Integer employid) {
        this.employid = employid;
    }

    public String getEmployInfo() {
        return employInfo;
    }

    public void setEmployInfo(String employInfo) {
        this.employInfo = employInfo == null ? null : employInfo.trim();
    }

    public String getEmployImg() {
        return employImg;
    }

    public void setEmployImg(String employImg) {
        this.employImg = employImg == null ? null : employImg.trim();
    }

    public Date getEmployTime() {
        return employTime;
    }

    public void setEmployTime(Date employTime) {
        this.employTime = employTime;
    }

    public String getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(String employStatus) {
        this.employStatus = employStatus == null ? null : employStatus.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFixid() {
        return fixid;
    }

    public void setFixid(Integer fixid) {
        this.fixid = fixid;
    }
}