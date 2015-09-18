package com.ync365.seed.bussiness.modules.goods.biz;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.goods.dao.CategoryDao;
import com.ync365.seed.bussiness.modules.goods.dao.FeatureDao;
import com.ync365.seed.bussiness.modules.goods.dao.FeatureValueDao;
import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.FeatureValue;
@Service
public class CategoryBiz  {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	FeatureDao featureDao; 
	
	@Autowired
	FeatureValueDao featureValueDao;
	/**
	 * 新增保存
	 * @param category
	 * @return
	 */
	public int add(Category category){
		//插入数据
		int a = categoryDao.insert(category);
		int categoryId = category.getCategoryId();
		
		return categoryId;
	}
	
	/**
	 * 更新path字段
	 * @param temp
	 */
	public void updatePathByCategoryId(int categoryId) {
		//通过category查询category对象
		Category category = categoryDao.selectByPrimaryKey(categoryId);
		//创建对象用于update 
		Category caa = new Category();
		
		if(0 == category.getParentId()){
			caa.setCategoryId(category.getCategoryId());
			//设置path字段  为 category.getCategoryId() 转换成字符串 
			caa.setPath(category.getCategoryId()+",");
		}else{
			//获取值  path字段  为 category.getCategoryId() 转换成字符串 
			String tem = category.getCategoryId()+",";
			//递归循环 
			String temp = this.getCategoryIds(tem ,category);
									
			caa.setCategoryId(category.getCategoryId());
			caa.setPath(temp);
		}
		//更新：Category  主要更新  path字段
		categoryDao.updateByPrimaryKeySelective(caa);
	}
	
	
	/**
	 * 递归循环 category.getParentId() = 0时终止递归循环   由 cate.getCategoryId()拼成字符串 tem 返回 
	 * @param tem
	 * @param category
	 * @return
	 */
	private String getCategoryIds(String tem, Category category) {
		Category cate = categoryDao.selectByPrimaryKey(category.getParentId());
		tem = cate.getCategoryId()+","+tem;
		if(0== cate.getParentId()){
			 return  tem;
		}else{
			return this.getCategoryIds(tem, cate);
		}
	}


	public List<Category> searchPage(String qName,int startIndex,int pageSize){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", qName);
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return categoryDao.searchPage(map);
	}

	public int searchPageCount(String categoryName) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String ,Object>();
		return categoryDao.searchPageCount(map);
		
	}
	
	public List<Category> selectCategoryAll() {
		// TODO Auto-generated method stub
		return categoryDao.selectCategoryAll();
	}

	public int deleteByPrimaryKey(Integer CategoryId) {
		// TODO Auto-generated method stub
		return categoryDao.deleteByPrimaryKey(CategoryId);
	}

	public int updateByPrimaryKey(Category c) {
		// TODO Auto-generated method stub
		return categoryDao.updateByPrimaryKeySelective(c);
	}

	public Category selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryDao.selectByPrimaryKey(id);
	}

	public int selectCountByParentId(Integer parentId) {
		return categoryDao.selectCountByParentId(parentId);
	}
	
	public List<Category> getCategoryByBrandId(Integer brandId){
		return categoryDao.getCategoryByBrandId(brandId);
	}
	
	public List<Category> getCategoryByParentId(Integer parentId){
		return categoryDao.getCategoryByParentId(parentId);
	}
	
	@Transactional
	public int add(Category category, List<Feature> fList){
		//插入数据
		int a = categoryDao.insert(category);
		int categoryId = category.getCategoryId();
		//addFeatures(fList);
		for (Feature feature : fList) {
			feature.setCategoryId(categoryId);
			int b = featureDao.insert(feature);
			if(b==1){
				Integer featureId = feature.getFeatureId();
				String[] optionals = feature.getOptionals().split(",");
				FeatureValue featureValue = new FeatureValue();
				for (String attrValue : optionals) {
					featureValue.setFeatureId(featureId);
					featureValue.setAttrValue(attrValue);
					featureValue.setIsDel(0);
					int c = featureValueDao.insert(featureValue);
					
				}
			}
		}
		return categoryId;
	}
	private void addFeatures(List<Feature> fList) {
		
		
	}
	
}
