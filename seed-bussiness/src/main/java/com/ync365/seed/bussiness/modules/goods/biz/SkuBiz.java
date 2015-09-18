package com.ync365.seed.bussiness.modules.goods.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.goods.dao.BrandDao;
import com.ync365.seed.bussiness.modules.goods.dao.CategoryDao;
import com.ync365.seed.bussiness.modules.goods.dao.FeatureDao;
import com.ync365.seed.bussiness.modules.goods.dao.GoodsDao;
import com.ync365.seed.bussiness.modules.goods.dao.OperateDao;
import com.ync365.seed.bussiness.modules.goods.dao.SkuDao;
import com.ync365.seed.bussiness.modules.goods.dao.SkuFeatureDao;
import com.ync365.seed.bussiness.modules.goods.entity.Brand;
import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.Goods;
import com.ync365.seed.bussiness.modules.goods.entity.Operate;
import com.ync365.seed.bussiness.modules.goods.entity.Sku;
import com.ync365.seed.bussiness.modules.goods.entity.SkuFeature;
import com.ync365.seed.commons.solr.SolrUtil;
import com.ync365.seed.utils.StringUtils;

@Service
public class SkuBiz {
	
	@Autowired
	SkuDao skuDao;
	
	@Autowired
	BrandDao brandDao ;
	
	@Autowired
	GoodsDao goodsDao;
	
	@Autowired
	SkuFeatureDao skuFeatureDao ;
	
	@Autowired
	FeatureDao featureDao ;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	OperateDao operateDao;

 
	public List<Sku> searchPage(Map<String, Object> map, int startIndex,
			int pageSize) {
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return skuDao.searchPage(map);
	}

	/**
	 * 商品审核列表
	 * @param map
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Sku> searchAuditPage(Map<String, Object> map, int startIndex,
			int pageSize) {
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return skuDao.searchAuditPage(map);
	}
	
	/**
	 * 商品发布列表
	 * @param map
	 * @param startIndex
	 * @param rows
	 * @return
	 */
	public List<Sku> searchReleasePage(Map<String, Object> map, int startIndex,
			int pageSize) {
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return skuDao.searchReleasePage(map);
	}
	
	public int searchPageCount(Map<String, Object> map) {
		return skuDao.searchPageCount(map);
	}
	
	@Transactional
	public int updateStatus(String skuId,int status){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("skuId", skuId);
		map.put("status", status);
		int update = skuDao.grounding(map) ;
		
		Operate record = new Operate();
		record.setSkuId(Integer.parseInt(skuId));
		if(status==3){
			record.setReleaseTime(new Date());
		}else if(status==4){
			record.setCancelReleaseTime(new Date());
		}
		//record.setReason("");
		
	 
		if(operateDao.selectByPrimaryKey(Integer.parseInt(skuId))!=null){
			update  = operateDao.updateByPrimaryKeySelective(record);
		}else{
			update  = operateDao.insert(record);
		}
		/**
		 * 状态为1并且 更新成功update=1 则建立索引
		 */
		if(3 == status  && update == 1 ){
			
			Sku sku = skuDao.selectByPrimaryKey(Integer.parseInt(skuId));
			
			//商品
			Goods goods = goodsDao.selectByPrimaryKey(sku.getGoodsId());
			
			//分类
			Category category = categoryDao.selectByPrimaryKey(goods.getCategoryId());
			String categoryName = "";
			if(category != null ){
				categoryName = category.getName() ;
			}
			
			//品牌
			Brand brand = brandDao.selectByPrimaryKey(goods.getBrandId());
			 
			
			Map<String,Object> solrMap = new HashMap<String, Object>();
			
			
			//索引字段：skuId,商品名称、属性、属性值、品牌、商品编码
			solrMap.put("id", sku.getSkuId());
			solrMap.put("name", sku.getGoodsName());
			
			Map<String,Object> skuFeatureMap = new HashMap<String,Object>();
			skuFeatureMap.put("skuId", skuId);
			
			//sku对应的所有属性列表
			List<SkuFeature> skuFeatureList = skuFeatureDao.selectListBySkuId(skuFeatureMap) ;
			String featureValue = "";
			String featureName = "";
			for(SkuFeature sf:skuFeatureList){
				featureValue += sf.getSpecValue() +"," ;
				Feature feature =  featureDao.selectByPrimaryKey(sf.getFeatureId());
				if(feature != null ){
					featureName += feature.getName() +"," ;
				}
			}
			
			//属性值合集
			if(StringUtils.isNotBlank(featureValue)){
				featureValue = featureValue.substring(0,featureValue.length()-1 );
			}
			
			//属性名称合集
			if(StringUtils.isNotBlank(featureName)){
				featureName = featureName.substring(0,featureName.length()-1);
			}
			
			solrMap.put("featureName", featureName);
			solrMap.put("featureValue", featureValue);
			
			if(brand != null ){
				solrMap.put("brandName", brand.getChName());
			}
			
			if(sku != null ){
				solrMap.put("code", sku.getGoodsCode());
			}
			solrMap.put("categoryName", categoryName);
 
			SolrUtil.addObject(solrMap );
		}else{
			try {
				SolrUtil.deleteDocByQuery(skuId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return update;
		
	}
	

	/**
	 * 商品审核
	 * @param skuId
	 * @param status
	 * @return
	 */
	@Transactional
	public int audit(String skuId,int status){
		
		//更新SKU表状态
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("skuId", skuId);
		map.put("status", status);
		int update =  skuDao.grounding(map) ;
		
		//写SKU操作表
		Operate record = new Operate();
		record.setSkuId(Integer.parseInt(skuId));
		record.setAuditTime(new Date());
		record.setReason("");
		if(operateDao.selectByPrimaryKey(Integer.parseInt(skuId))!=null){
			update = operateDao.updateByPrimaryKeySelective(record);
		}else{
			update = operateDao.insert(record);
		}
		return  update ;
	}


	public Sku searchSkuById(Integer skuid) {
		Sku sku=skuDao.selectByPrimaryKey(skuid);
		return sku;
	}

	@Transactional
	public int disPassAudit(String skuId, String status, String reason) {
		//更新SKU表状态
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("skuId", skuId);
		map.put("status", status);
		int update =  skuDao.grounding(map) ;
		if(update!=1){
			return update;
		}
		//写SKU操作表
		Operate record = new Operate();
		record.setSkuId(Integer.parseInt(skuId));
		record.setAuditTime(new Date());
		record.setReason(reason);
		if(operateDao.selectByPrimaryKey(Integer.parseInt(skuId))!=null){
			update = operateDao.updateByPrimaryKeySelective(record);
		}else{
			update = operateDao.insert(record);
		}
		return  update ;
	}






}
