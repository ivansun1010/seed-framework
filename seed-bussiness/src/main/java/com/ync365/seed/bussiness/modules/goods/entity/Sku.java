package com.ync365.seed.bussiness.modules.goods.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Sku {
	
    private Integer skuId;

    private Integer goodsId;
 
    /**
     * 商品货号
     */
    private String sku;

    /**
     * 库存
     */
    private BigDecimal stockNum;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 零售价
     */
    private BigDecimal sellPrice;
    
    /**
     * 成本价
     */
    private BigDecimal costPrice ;

    private BigDecimal lowerLimit;

    private BigDecimal upperLimit;

    private String goodsName;

    private int ftype;

    private Integer sort;

    private Long salesCount;
    
    private int isGood;
    
    private int isHot;

    /**
     * 1:通过  2：未通过  3：上架  4：下架   0：默认未审核
     */
    private int status;

    private String barCode;

    private String goodsCode;

    private Date createTime;

    private Date optDate;

    private Integer optUser;

    private String optTerm;
    
    /**
     * 删除标识符  1删除 0未删除
     */
    private Integer isDelete;
    private List<SkuFeature> skuFeatures;
    
    
	public List<SkuFeature> getSkuFeatures() {
		return skuFeatures;
	}
	public void setSkuFeatures(List<SkuFeature> skuFeatures) {
		this.skuFeatures = skuFeatures;
	}
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
 
	public BigDecimal getStockNum() {
		return stockNum;
 
	}
 
	public void setStock(BigDecimal stockNum) {
		this.stockNum = stockNum;
 
	}
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public BigDecimal getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(BigDecimal lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public BigDecimal getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(BigDecimal upperLimit) {
		this.upperLimit = upperLimit;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getFtype() {
		return ftype;
	}
	public void setFtype(int ftype) {
		this.ftype = ftype;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	 
	public Long getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(Long salesCount) {
		this.salesCount = salesCount;
	}
	public void setStockNum(BigDecimal stockNum) {
		this.stockNum = stockNum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getOptDate() {
		return optDate;
	}
	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}
	public Integer getOptUser() {
		return optUser;
	}
	public void setOptUser(Integer optUser) {
		this.optUser = optUser;
	}
	public String getOptTerm() {
		return optTerm;
	}
	public void setOptTerm(String optTerm) {
		this.optTerm = optTerm;
	}
	public int getIsGood() {
		return isGood;
	}
	public void setIsGood(int isGood) {
		this.isGood = isGood;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}


     
}