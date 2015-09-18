package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.user.entity.SysAdmin;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysAdminMapper {
	/**
	 * 编号删除信息，物理删除
	 * 
	 * @param adminNum
	 * @return
	 */
	int deleteByPrimaryKey(String adminNum);

	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(SysAdmin record);

	/**
	 * 编号获取信息
	 * 
	 * @param adminNum
	 * @return
	 */
	SysAdmin selectByPrimaryKey(String adminNum);

	/**
	 * 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(SysAdmin record);

	/**
	 * 多功能查询，分页添加pageIndex,pageSize参数
	 * 
	 * @param map
	 * @return
	 */
	List<SysAdmin> selectPageByMap(Map<String, Object> map);

	/**
	 * 条件获取数量
	 * 
	 * @param map
	 * @return
	 */
	int selectPageCount(Map<String, Object> map);
}