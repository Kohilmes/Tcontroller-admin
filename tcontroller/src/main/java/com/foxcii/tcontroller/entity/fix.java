package com.foxcii.tcontroller.entity;

public class fix {
    private Integer fixid;

    private String fixName;

    private String fixPwd;

    private String fixInfo;

    private String fixGrade;

    public Integer getFixid() {
        return fixid;
    }

    public void setFixid(Integer fixid) {
        this.fixid = fixid;
    }

    public String getFixName() {
        return fixName;
    }

    public void setFixName(String fixName) {
        this.fixName = fixName == null ? null : fixName.trim();
    }

    public String getFixPwd() {
        return fixPwd;
    }

    public void setFixPwd(String fixPwd) {
        this.fixPwd = fixPwd == null ? null : fixPwd.trim();
    }

    public String getFixInfo() {
        return fixInfo;
    }

    public void setFixInfo(String fixInfo) {
        this.fixInfo = fixInfo == null ? null : fixInfo.trim();
    }

    public String getFixGrade() {
        return fixGrade;
    }

    public void setFixGrade(String fixGrade) {
        this.fixGrade = fixGrade == null ? null : fixGrade.trim();
    }
}