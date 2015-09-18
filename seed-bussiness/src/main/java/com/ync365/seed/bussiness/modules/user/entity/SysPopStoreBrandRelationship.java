package com.ync365.seed.bussiness.modules.user.entity;

public class SysPopStoreBrandRelationship {
    private String popStoreNum;

    private Integer brandId;

    public String getPopStoreNum() {
        return popStoreNum;
    }

    public void setPopStoreNum(String popStoreNum) {
        this.popStoreNum = popStoreNum == null ? null : popStoreNum.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}