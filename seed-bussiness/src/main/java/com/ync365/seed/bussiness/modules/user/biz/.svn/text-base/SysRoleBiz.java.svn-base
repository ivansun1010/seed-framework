package com.ync365.seed.bussiness.modules.user.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.user.dao.SysModuleMapper;
import com.ync365.seed.bussiness.modules.user.dao.SysRoleMapper;
import com.ync365.seed.bussiness.modules.user.dao.SysRoleModuleMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysModule;
import com.ync365.seed.bussiness.modules.user.entity.SysRole;



@Service
public class SysRoleBiz {
	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysRoleModuleMapper sysRoleModuleMapper;
	/**
	 * 分页查询list
	 * @param map
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	/*public List<SysRole> searchPage(Map<String, Object> map,int startIndex,int pageSize){
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return sysRoleMapper.searchPage(map);
	}*/

	/**
	 * 分页查询统计count
	 * @param map
	 * @return
	 */
	/*public long searchPageCount(Map<String, Object> map) {
		return sysRoleMapper.searchPageCount(map);
	}*/

	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	public SysRole selectByPrimaryKey(Integer id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加
	 * @param sysModule
	 * @return
	 */
	public int insert(SysRole sysModule) {
		return sysRoleMapper.insert(sysModule);
	}
	
	/**
	 * 编辑  by id
	 * @param sysModule
	 * @return
	 */
	public int updateByPrimaryKey(SysRole sysModule) {
		return sysRoleMapper.updateByPrimaryKey(sysModule);
	}
	
	/**
	 * 删除 by id
	 * @param id
	 * @return
	 */
	/*@Transactional
	public int deleteByPrimaryKey(Integer id){
		//删除角色权限关系表 及 角色中的数据
		int a = sysRoleModuleMapper.deleteByRoleId(id);
		return sysRoleMapper.deleteByPrimaryKey(id);
	}*/

}
