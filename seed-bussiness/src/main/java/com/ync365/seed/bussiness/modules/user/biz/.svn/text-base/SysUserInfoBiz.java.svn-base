package com.ync365.seed.bussiness.modules.user.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysUserInfoMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysUserInfo;

@Service
public class SysUserInfoBiz {
	
	@Autowired
	SysUserInfoMapper sysUserInfoMapper;
	
	/**
	 * 编号删除信息，物理删除
	 * 
	 * @param String userNum
	 * @return
	 */
    public int deleteByPrimaryKey(String userNum) {
		return sysUserInfoMapper.deleteByPrimaryKey(userNum);
    }
    
    /**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(SysUserInfo record) {
		return sysUserInfoMapper.insertSelective(record);
	}
	
	/**
	 * 编号获取信息
	 * 
	 * @param userNum
	 * @return
	 */
	public SysUserInfo selectByPrimaryKey(String userNum) {
		return sysUserInfoMapper.selectByPrimaryKey(userNum);
	}
    
	/**
	 * 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysUserInfo record) {
		return sysUserInfoMapper.updateByPrimaryKeySelective(record);
	} 
	
	/**
	 * 多功能查询，分页添加pageIndex,pageSize参数
	 * 
	 * @param map
	 * @return
	 */
	public List<SysUserInfo> selectPageByMap(Map<String, Object> map) {
		return sysUserInfoMapper.selectPageByMap(map);
	}
	
	/**
	 * 条件获取数量
	 * 
	 * @param map
	 * @return
	 */
	public int selectPageCount(Map<String, Object> map) {
		return sysUserInfoMapper.selectPageCount(map);
	}
    
    

}
