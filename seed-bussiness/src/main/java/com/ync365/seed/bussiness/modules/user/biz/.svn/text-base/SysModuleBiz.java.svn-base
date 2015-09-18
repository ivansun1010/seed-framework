package com.ync365.seed.bussiness.modules.user.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysModuleMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysModule;



@Service
public class SysModuleBiz {
	@Autowired
	SysModuleMapper sysModuleMapper;
	
	/**
	 * 分页查询list
	 * @param map
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SysModule> searchPage(Map<String, Object> map,int startIndex,int pageSize){
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return sysModuleMapper.searchPage(map);
	}

	/**
	 * 分页查询统计count
	 * @param map
	 * @return
	 */
	public long searchPageCount(Map<String, Object> map) {
		return sysModuleMapper.searchPageCount(map);
	}

	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	public SysModule selectByPrimaryKey(Integer id) {
		return sysModuleMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加
	 * @param sysModule
	 * @return
	 */
	public int insert(SysModule sysModule) {
		//0 为父目录
		if (null == sysModule.getParentId()) {
			sysModule.setParentId(0);
		}
		return sysModuleMapper.insert(sysModule);
	}
	
	/**
	 * 编辑  by id
	 * @param sysModule
	 * @return
	 */
	public int updateByPrimaryKey(SysModule sysModule) {
		return sysModuleMapper.updateByPrimaryKey(sysModule);
	}
	
	/**
	 * 删除 by id
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return sysModuleMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 获取所有 list  通过map对象 传递参数
	 * @return
	 */
	public List<SysModule> selectSysModuleAllByMap(Map<String, Object> map) {
		return sysModuleMapper.selectSysModuleAllByMap(map);
	}
}
