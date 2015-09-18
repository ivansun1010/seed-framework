package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface CategoryDao {
	int deleteByPrimaryKey(Integer categoryId);

	int insert(Category record);

	int insertSelective(Category record);

	Category selectByPrimaryKey(Integer categoryId);

	int updateByPrimaryKeySelective(Category record);

	int updateByPrimaryKey(Category record);

	List<Category> searchPage(Map<String, Object> map);

	int searchPageCount(Map<String, Object> map);
	
	List<Category> selectCategoryAll();

	int selectCountByParentId(Integer parentId);
	//List<Tree> selectCategoryByParentId(Long parentId);
	
	List<Category> getCategoryByBrandId(Integer brandId);
	
	List<Category> getCategoryByParentId(Integer parentId);
}