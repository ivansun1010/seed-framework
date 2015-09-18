package com.ync365.seed.admin.vo.goods;

import java.util.List;

import com.ync365.seed.bussiness.modules.goods.entity.Blob;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.Goods;
import com.ync365.seed.bussiness.modules.goods.entity.HoldGold;

/**
 * 商品Vo
 *
 */
public class GoodsVo {

	/**
	 * 商品
	 */
	private Goods goods;

	/**
	 * 属性
	 */
	private List<Feature> features;
	
	/**
	 * 拥金
	 */
	private HoldGold holdGold ;
	
	/**
	 * 商品详情
	 * */
	private Blob blob;

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public HoldGold getHoldGold() {
		return holdGold;
	}

	public void setHoldGold(HoldGold holdGold) {
		this.holdGold = holdGold;
	}

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	
	
}
