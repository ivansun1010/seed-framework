package com.ync365.seed.bussiness.modules.goods.entity;

import java.math.BigDecimal;

public class HoldGold {
	
	/**
	 * 商品主键
	 */
    private Integer goodsId;

    /**
     * vs 拥金
     */
    private BigDecimal vsAmount;

    /**
     * lc 拥金 
     */
    private BigDecimal lcAmount;

    /**
     * 工程师拥金 
     */
    private BigDecimal engineerAmount;

    /**
     * A+ 组长拥金 
     */
    private BigDecimal aAmount;

    /**
     * 供应商拥金
     */
    private BigDecimal supplierAmount;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getVsAmount() {
        return vsAmount;
    }

    public void setVsAmount(BigDecimal vsAmount) {
        this.vsAmount = vsAmount;
    }

    public BigDecimal getLcAmount() {
        return lcAmount;
    }

    public void setLcAmount(BigDecimal lcAmount) {
        this.lcAmount = lcAmount;
    }

    public BigDecimal getEngineerAmount() {
        return engineerAmount;
    }

    public void setEngineerAmount(BigDecimal engineerAmount) {
        this.engineerAmount = engineerAmount;
    }

    public BigDecimal getaAmount() {
        return aAmount;
    }

    public void setaAmount(BigDecimal aAmount) {
        this.aAmount = aAmount;
    }

    public BigDecimal getSupplierAmount() {
        return supplierAmount;
    }

    public void setSupplierAmount(BigDecimal supplierAmount) {
        this.supplierAmount = supplierAmount;
    }
}