package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.SkuFeature;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface SkuFeatureDao {
    int deleteByPrimaryKey(Integer tid);

    int insert(SkuFeature record);

    int insertSelective(SkuFeature record);

    SkuFeature selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(SkuFeature record);

    int updateByPrimaryKey(SkuFeature record);
    
    public List<SkuFeature> selectListBySkuId(Map<String, Object> map);
    
    public List<Map<String,Object>> selectAllFeaturesBySkuId(Map<String, Object> map);
    
    public List<Feature> selectFeaturesIdByGoodsId(@Param("goodsId") Integer goodsId,@Param("isSpec") Integer isSpec);
    
}