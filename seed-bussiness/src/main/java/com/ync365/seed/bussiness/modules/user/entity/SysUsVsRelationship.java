package com.ync365.seed.bussiness.modules.user.entity;

public class SysUsVsRelationship {
    private String usNum;

    private String vsNum;

    public String getUsNum() {
        return usNum;
    }

    public void setUsNum(String usNum) {
        this.usNum = usNum == null ? null : usNum.trim();
    }

    public String getVsNum() {
        return vsNum;
    }

    public void setVsNum(String vsNum) {
        this.vsNum = vsNum == null ? null : vsNum.trim();
    }
}