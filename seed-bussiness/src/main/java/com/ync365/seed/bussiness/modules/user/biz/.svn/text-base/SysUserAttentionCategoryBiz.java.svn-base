package com.ync365.seed.bussiness.modules.user.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysUserAttentionCategoryMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysUserAttentionCategory;




@Service
public class SysUserAttentionCategoryBiz {
	@Autowired
	SysUserAttentionCategoryMapper sysUserAttentionCategoryMapper;
	
	/**
	 * 添加对象 insert
	 * @param record
	 * @return
	 */
	public int insert( SysUserAttentionCategory record){
		return sysUserAttentionCategoryMapper.insertSelective(record);
	}
	
	/**
	 * 通过userNum删除数据
	 * @param userNum
	 * @return
	 */
	public int deleteByUserNumm(String userNum){
		return sysUserAttentionCategoryMapper.deleteByUserNumm(userNum);
	}
	
	/**
	 * 通过userNum查询 List<SysUserAttentionCategory>
	 * @param userNum
	 * @return
	 */
	public List<SysUserAttentionCategory> selectPageByMap(Map<String, Object> map){
		return  sysUserAttentionCategoryMapper.selectPageByMap(map);
	}
	
}
