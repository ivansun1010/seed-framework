package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;

import com.ync365.seed.bussiness.modules.user.entity.SysRole;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

	List<SysRole> selectSysRoleByAdminNum(String adminNum);
}