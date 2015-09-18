package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysUserRole;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysUserRoleMapper {
	
    /**
     * 添加信息
     * 
     * @param record
     * @return
     */
    int insert(SysUserRole record);

    /**
     * 添加信息
     * 
     * @param record
     * @return
     */
    int insertSelective(SysUserRole record);
}