package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.user.entity.SysUserAttentionBrand;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysUserAttentionBrandMapper {

	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
    int insertSelective(SysUserAttentionBrand record);
    
    /**
	 * 物理  通过 userNum删除数据
	 * 
	 * @param userNum
	 * @return
	 */
	int deleteByUserNumm(String userNum);
	
	/**
	 * userNum为条件更新
	 * 
	 * @param record
	 * @return
	 */
	int update(SysUserAttentionBrand record);
	
	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	List<SysUserAttentionBrand> selectPageByMap(Map<String, Object> map);
}