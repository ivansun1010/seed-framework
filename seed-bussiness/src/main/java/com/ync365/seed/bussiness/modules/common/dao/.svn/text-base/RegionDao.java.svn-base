package com.ync365.seed.bussiness.modules.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ync365.seed.bussiness.modules.common.entity.Region;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface RegionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
    
    List<Region> selectListByLevel(@Param("levelList")List<Integer> levelList) ;
    
    public List<Region> searchPage(Map<String,Object> map);

	int searchPageCount(Map<String, Object> map);
}