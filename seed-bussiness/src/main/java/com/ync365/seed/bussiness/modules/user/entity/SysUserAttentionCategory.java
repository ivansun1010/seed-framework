package com.ync365.seed.bussiness.modules.user.entity;

public class SysUserAttentionCategory {
	/**
	 * 用户编号
	 */
    private String userNum;

    /**
     * 类别ID
     */
    private Integer categoryId;

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}