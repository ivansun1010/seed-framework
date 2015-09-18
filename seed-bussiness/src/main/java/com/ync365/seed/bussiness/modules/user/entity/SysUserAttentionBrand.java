package com.ync365.seed.bussiness.modules.user.entity;

public class SysUserAttentionBrand {
	/**
	 * 用户编号
	 */
    private String userNum;

    /**
     * 品牌ID
     */
    private Integer brandId;

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}