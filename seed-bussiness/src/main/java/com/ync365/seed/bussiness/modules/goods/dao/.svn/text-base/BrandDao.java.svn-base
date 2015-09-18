package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.goods.entity.Brand;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface BrandDao {
    int deleteByPrimaryKey(Integer brandId);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer brandId);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
    
    public List<Brand> searchPage(Map<String,Object> map);
    
    public int  searchPageCount(Map<String,Object> map);
    
    public List<Brand> getAllbrandList();
}