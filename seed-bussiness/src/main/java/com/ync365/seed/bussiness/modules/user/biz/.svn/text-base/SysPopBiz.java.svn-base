package com.ync365.seed.bussiness.modules.user.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysPopMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysPop;


@Service
public class SysPopBiz {
	@Autowired
	SysPopMapper sysPopMapper;
	
	/**
	 * 通过主键id查询对象
	 * @param id
	 * @return
	 */
	public SysPop selectByPrimaryKey(Integer id) {
		return sysPopMapper.selectByPrimaryKey(id);
	}
	
	
	
	/**
	 * 通过主键id删除对象
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return sysPopMapper.deleteByPrimaryKey(id);
	}
	
	
	
	/**
	 * 添加对象 insert
	 * @param record
	 * @return
	 */
	public int insert(SysPop record){
		return sysPopMapper.insert(record);
	}
	
	/**
	 * 更新数据
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(SysPop record){
		return sysPopMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 更新数据修改字段为null则不修改
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysPop record){
		return sysPopMapper.updateByPrimaryKeySelective(record);
	}
	
}
