package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.user.entity.SysUserAttentionCategory;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysUserAttentionCategoryMapper {

	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
    int insertSelective(SysUserAttentionCategory record);
    
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
	int update(SysUserAttentionCategory record);
	
	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	List<SysUserAttentionCategory> selectPageByMap(Map<String, Object> map);
}