package com.foxcii.tcontroller.entity;

import java.util.Date;

public class know {
    private Integer knowid;

    private String submitTime;

    private String knowInfo;

    private String knowImg;

    private Integer goodNum;

    private String mdfile;

    public Integer getKnowid() {
        return knowid;
    }

    public void setKnowid(Integer knowid) {
        this.knowid = knowid;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getKnowInfo() {
        return knowInfo;
    }

    public void setKnowInfo(String knowInfo) {
        this.knowInfo = knowInfo == null ? null : knowInfo.trim();
    }

    public String getKnowImg() {
        return knowImg;
    }

    public void setKnowImg(String knowImg) {
        this.knowImg = knowImg == null ? null : knowImg.trim();
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public String getMdfile() {
        return mdfile;
    }

    public void setMdfile(String mdfile) {
        this.mdfile = mdfile;
    }
}