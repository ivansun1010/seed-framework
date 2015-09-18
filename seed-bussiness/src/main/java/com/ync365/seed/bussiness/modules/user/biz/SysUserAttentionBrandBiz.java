package com.ync365.seed.bussiness.modules.user.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysUserAttentionBrandMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysUserAttentionBrand;



@Service
public class SysUserAttentionBrandBiz {
	@Autowired
	SysUserAttentionBrandMapper sysUserAttentionBrandMapper ; 
	
	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	public int insert(SysUserAttentionBrand record){
		return sysUserAttentionBrandMapper.insertSelective(record);
	}
	
	/**
	 * 物理  通过 userNum删除数据
	 * 
	 * @param userNum
	 * @return
	 */
	public int deleteByUserNumm(String userNum){
		return   sysUserAttentionBrandMapper.deleteByUserNumm(userNum);
	}
	
	/**
	 * 通过map 查询 List<SysUserAttentionBrand>
	 * @param map
	 * @return
	 */
	public List<SysUserAttentionBrand> selectPageByMap(Map<String, Object> map){
		return  sysUserAttentionBrandMapper.selectPageByMap(map);
	}
	
}
