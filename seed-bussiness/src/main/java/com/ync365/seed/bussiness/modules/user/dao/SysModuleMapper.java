package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.user.entity.SysModule;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysModuleMapper {
	
	/**
	 * 删除 by id
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
	 * 添加
	 * @param sysModule
	 * @return
	 */
    int insert(SysModule record);

    /**
	 * 添加  
	 * @param sysModule
	 * @return
	 */
    int insertSelective(SysModule record);

    /**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
    SysModule selectByPrimaryKey(Integer id);

    /**
	 * 编辑  更新 by id  如果对象更新字段为null 则不更新 数据库中的信息
	 * @param sysModule
	 * @return
	 */
    int updateByPrimaryKeySelective(SysModule record);

    /**
	 * 编辑  更新 by id
	 * @param sysModule
	 * @return
	 */
    int updateByPrimaryKey(SysModule record);
    
    /**
	 * 分页查询list
	 * @param map
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
    List<SysModule> searchPage(Map<String, Object> map);
    
    /**
	 * 分页查询统计count
	 * @param map
	 * @return
	 */
    int searchPageCount(Map<String, Object> map);

    /**
	 * 获取所有 list  通过map对象 传递参数
	 * @return
	 */
	List<SysModule> selectSysModuleAllByMap(Map<String, Object> map);
}