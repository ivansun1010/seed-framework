package com.ync365.seed.bussiness.modules.goods.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.goods.dao.FeatureDao;
import com.ync365.seed.bussiness.modules.goods.dao.FeatureValueDao;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.FeatureValue;

@Service
public class FeatureBiz {

	@Autowired
	FeatureDao featureDao;
	
	@Autowired
	FeatureValueDao featureValueDao; 
	
	@Transactional
	public int add(Feature feature,List<FeatureValue> featureValue) {
		featureDao.insert(feature);
		int featureId  = feature.getFeatureId();
		for (FeatureValue fv: featureValue) {
			fv.setFeatureId(featureId);
			fv.setIsDel(0);
			featureValueDao.insert(fv);
		}
		return featureId;
		
	}

	public List<Feature> searchPage(String qName, int startIndex,
			int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", qName);
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return featureDao.searchPage(map);
	}

	public int searchPageCount(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		return featureDao.searchPageCount(map);
	}

	@Transactional
	public int deleteById(int id) {
		featureValueDao.deleteByFeatureId(id);
		return featureDao.deleteByPrimaryKey(id);
	}

	public Feature selectById(int id) {
		return featureDao.selectByPrimaryKey(id);
	}

	/**
	 * 1.查询出featureId对应的所有FeatureValue的featurevalue对象
	 * 2.循环list<featurevalue>对象取featurevalue值字符串
	 * 3.判断page页面传过来是否存在，没有逻辑删除。
	 * 4.循环list<String>page页面的值，如果数据库中没有，添加一个featurevalue
	 * @param list 
	 * 
	 */		
	@Transactional
	public int edit(Feature feature, List<FeatureValue> list) {

		featureDao.updateByPrimaryKeySelective(feature);
		int featureId  = feature.getFeatureId();
		
		//编辑页面属性值字符串
		List<String> pageFVList = null;
		for (FeatureValue featureValue : list) {
			pageFVList.add(featureValue.getAttrValue());
		}

		
		//page跟数据库都有的featurevalue
		List<String> bothHave = new ArrayList<String>();

		List<FeatureValue> dbFeatureValueList = featureValueDao.selectFeatureValueListByFeatureId(featureId);
		for (FeatureValue dbFeatureValue : dbFeatureValueList) {
			if(!pageFVList.contains(dbFeatureValue.getAttrValue())){
				//页面有，数据库没有，逻辑删除
				dbFeatureValue.setIsDel(1);
				featureValueDao.updateByPrimaryKeySelective(dbFeatureValue);
			}else{
				bothHave.add(dbFeatureValue.getAttrValue());
			}
		}
		
		//页面上有，数据库没有的，数据库中加进去
		FeatureValue featureValue = new FeatureValue();
		for (String pageValue : pageFVList) {
			if(!bothHave.contains(pageValue)){
				featureValue.setFeatureId(featureId);
				featureValue.setAttrValue(pageValue);
				featureValue.setIsDel(0);
				featureValueDao.insert(featureValue);
			}
		}
		
		return featureId;
	}

	public List<Feature> getFeaturesBySpec(int specValue) {
		return featureDao.getFeaturesBySpec(specValue);
	}

	public List<Feature> getFeaturesBySpecAndCategoryId(int specValue,
			Integer categoryId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSpec", specValue);
		map.put("categoryId", categoryId);
		List<Feature> listFeatures = featureDao.searchPage(map);
		return listFeatures;
	}

	public List<Feature> getFeaturesByCategoryId(Integer categoryId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryId", categoryId);
		List<Feature> listFeatures = featureDao.searchPage(map);
		for (Feature feature : listFeatures) {
			if (feature.getIsSpec() == 1 || feature.getIsInput()!=1) {//除输入字段外全部实现可选择
				Map<String, String> map1 = new HashMap<String, String>();
				map1.put("featureId", feature.getFeatureId().toString());
				List<FeatureValue> listFeatureValues = featureValueDao
						.selectFeatureListByMap(map1);
				feature.setFeatureValues(listFeatureValues);
			}
		}
		
		
		return listFeatures;
	}

	public List<Feature> getParentFeatures() {
		return featureDao.getParentFeatures();
	}

	public List<Feature> getAllFeatures() {
		return featureDao.getAllFeatures();
	}

	/*
	 * 通过featureId获取到FeatureValue
	 */
	public List<FeatureValue> getFeatureValueByFeatureId(Integer featureId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("featureId", featureId.toString());
		return featureValueDao.selectFeatureListByMap(map);
	}

}
