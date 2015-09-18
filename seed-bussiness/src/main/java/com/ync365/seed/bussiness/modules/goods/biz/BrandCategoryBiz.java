package com.ync365.seed.bussiness.modules.goods.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.goods.dao.BrandCategoryDao;
import com.ync365.seed.bussiness.modules.goods.entity.BrandCategory;

@Service
public class BrandCategoryBiz   {

	@Autowired
	BrandCategoryDao brandCategoryDao ;
	
	public int addBrandCategory(BrandCategory brandCategory){
		return brandCategoryDao.insert(brandCategory);
	}
	
	@Transactional
	public int addBrandCategorys(Integer brandId,String categoryIds ){
		String [] ids = categoryIds.split(",");
		int returnValue = 0 ;
		for(String id:ids){
			/**
			 * 判断是否保存过
			 */
			BrandCategory brandCategory = searchBrandCategory(brandId,new Integer(id));
			if(brandCategory == null ){
			
				BrandCategory bc = new BrandCategory();
				bc.setBrandId(brandId);
				bc.setCategoryId(new Integer(id));
				returnValue = brandCategoryDao.insert(bc);
			}
		}
		return returnValue ;
	}
	
	public int deleteById(Long brandId,Long categoryId){
		return 1;
	}
	
	public int deleteById(Integer brandId){
		return brandCategoryDao.deleteById(brandId);
	}
	
	public List<BrandCategory> searchBrandCategoryList(Integer brandId){
		return brandCategoryDao.searchBrandCategoryList(brandId);
	}
	
	public BrandCategory searchBrandCategory(Integer brandId,Integer categoryId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("brandId", brandId);
		map.put("categoryId", categoryId);
		
		return brandCategoryDao.searchBrandCategory(map);
	}
	
}
