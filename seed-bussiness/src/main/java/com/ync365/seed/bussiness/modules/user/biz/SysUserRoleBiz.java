package com.ync365.seed.bussiness.modules.user.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysUserRoleMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysUserRole;

@Service
public class SysUserRoleBiz {
	@Autowired
	SysUserRoleMapper sysUserRoleMapper ;
	

	/**
     * 功能描述：添加用户
     * @param record
     * @return
     */
    public int insert(SysUserRole record) {
    	return sysUserRoleMapper.insert(record);
    }
    
    /**
     * 功能描述：查询用户by user_num
     * @param 
     * @return
     */
    public SysUserRole selectByPrimaryKey(String userNum) {
    	return null; //sysUserRoleMapper.selectByPrimaryKey(userNum);
    }
    
    /**
     * 功能描述：查询用户by roleId
     * @param 
     * @return
     */
    public SysUserRole selectByPrimaryKeyByRoleId(Integer id) {
    	return null ;// sysUserRoleMapper.selectByPrimaryKeyByRoleId(id);
    }
    
    /**
     * 功能描述：删除用户 by user_num
     * @param 
     * @return
     */
    public int deleteByPrimaryKey(String userNum) {
		return 0; //sysUserRoleMapper.deleteByPrimaryKey(userNum);
    }
}
