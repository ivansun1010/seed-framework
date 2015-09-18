package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.goods.entity.Sku;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface SkuDao {
	
	int deleteByPrimaryKey(Integer skuId);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer skuId);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
 
    List<Sku> selectByGoodsId(Integer goodsId);
   
    int updateByGoodsId(Sku record);
    
    List<Sku> searchPage(Map<String ,Object> map);
	
	int searchPageCount(Map<String,Object> map);
 
	/**
	 * 上下架
	 * @param map
	 * @return
	 */
	int grounding(Map<String,Object> map);

	/**
	 * 审核列表
	 * @param map
	 * @return
	 */
	List<Sku> searchAuditPage(Map<String, Object> map);

	/**
	 * 发布列表
	 * @param map
	 * @return
	 */
	List<Sku> searchReleasePage(Map<String, Object> map);
  
}