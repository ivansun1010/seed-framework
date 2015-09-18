package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysUser;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysUserMapper {
	
	/**
	 * 删除信息，物理删除
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	int insert(SysUser record);

	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(SysUser record);
	
	/**
	 * id获取编号信息
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectByPrimaryKey(Integer id);
	
	/**
	 * 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(SysUser record);

	/**
	 * 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(SysUser record);
}