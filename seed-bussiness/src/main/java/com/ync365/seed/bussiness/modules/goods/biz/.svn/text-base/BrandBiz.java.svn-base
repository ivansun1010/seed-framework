package com.ync365.seed.bussiness.modules.goods.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.goods.dao.BrandCategoryDao;
import com.ync365.seed.bussiness.modules.goods.dao.BrandDao;
import com.ync365.seed.bussiness.modules.goods.entity.Brand;
import com.ync365.seed.bussiness.modules.goods.entity.BrandCategory;

@Service
public class BrandBiz {

	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private BrandCategoryDao brandCategoryDao;
	
	/**
	 * 添加品牌
	 * @return 
	 */
	public int addBrand(Brand brand) {
		return brandDao.insert(brand);
	} 
	
	public List<Brand> searchPage(String qChName,int startIndex,int pageSize){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("chName", qChName);
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return brandDao.searchPage(map);
	}

	public long searchPageCount(String brandName) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("brandName", brandName);
		return brandDao.searchPageCount(map);
	}

	public int deleteById(Integer id) {
		return brandDao.deleteByPrimaryKey(id);
	}

	public Brand selectById(Integer id) {
		return brandDao.selectByPrimaryKey(id);
	}

	public int edit(Brand brand) {
		return brandDao.updateByPrimaryKeySelective(brand);
	}

	public int relate(BrandCategory record) {
		return brandCategoryDao.insert(record);
	}
	
	public List<Brand> getAllbrandList(){
		return brandDao.getAllbrandList();
	}
 
}
