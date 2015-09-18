package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysUserWorkRelationship;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysUserWorkRelationshipMapper {
	
    /**
     * 添加信息
     * 
     * @param record
     * @return
     */
    int insert(SysUserWorkRelationship record);

    /**
     * 添加信息
     * 
     * @param record
     * @return
     */
    int insertSelective(SysUserWorkRelationship record);
}