package com.ync365.seed.bussiness.modules.user.entity;

public class SysUserGrowKindRelationship {
	/**
	 * 用户编号
	 */
    private String userNum;

    /**
     * 种植类型编号
     */
    private Integer growKindId;

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public Integer getGrowKindId() {
        return growKindId;
    }

    public void setGrowKindId(Integer growKindId) {
        this.growKindId = growKindId;
    }
}