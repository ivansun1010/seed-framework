package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.user.entity.SysAdmin;
import com.ync365.seed.bussiness.modules.user.entity.SysUserInfo;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysUserInfoMapper {
	/**
	 * 编号删除信息，物理删除
	 * 
	 * @param String userNum
	 * @return
	 */
	int deleteByPrimaryKey(String userNum);
	
	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(SysUserInfo record);
	
	/**
	 * 编号获取信息
	 * 
	 * @param userNum
	 * @return
	 */
	SysUserInfo selectByPrimaryKey(String userNum);
	
	/**
	 * 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(SysUserInfo record);

	/**
	 * 多功能查询，分页添加pageIndex,pageSize参数
	 * 
	 * @param map
	 * @return
	 */
	List<SysUserInfo> selectPageByMap(Map<String, Object> map);
	
	/**
	 * 条件获取数量
	 * 
	 * @param map
	 * @return
	 */
	int selectPageCount(Map<String, Object> map);
}