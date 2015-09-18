package com.ync365.seed.bussiness.modules.promotion.entity;

import java.io.Serializable;
import java.util.Date;


/**
 *  
 * @author codegen 2015-09-15 18:21:55 
 */
public class PromotionGiftGoods implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/**  **/ 
	private int id;
	
    /**  **/ 
	private int promotionId;
	
    /**  **/ 
	private int goodsId;
	
    /**  **/ 
	private int skuId;
	
    /**  **/ 
	private int count;
	
    /**  **/ 
	private int isDelete;
	

	/**
	 * 构造 
	 */
	public PromotionGiftGoods() {
	}
	
	/**
	public PromotionGiftGoods( int id,  int promotionId  int goodsId  int skuId  int count  int isDelete ) {
				this.promotionId = promotionId;
				this.goodsId = goodsId;
				this.skuId = skuId;
				this.count = count;
				this.isDelete = isDelete;
						this.id = id;
			}
	*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}