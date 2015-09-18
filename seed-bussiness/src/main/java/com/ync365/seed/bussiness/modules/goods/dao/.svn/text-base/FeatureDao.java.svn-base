package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.FeatureValue;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface FeatureDao {
	int deleteByPrimaryKey(Integer featureId);

    int insert(Feature record);

    int insertSelective(Feature record);

    public Feature selectByPrimaryKey(Integer featureId);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);
    
    public List<Feature> searchPage(Map<String,Object> map);
    
    public int searchPageCount(Map<String,Object> map);
    
    public List<Feature> getFeaturesBySpec(int specValue);

	List<Feature> getParentFeatures();

	List<Feature> getAllFeatures();

	List<FeatureValue> selectFeatureValues(Integer id);
}