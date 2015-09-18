package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysPop;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysPopMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysPop record);

	int insertSelective(SysPop record);

	SysPop selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysPop record);

	int updateByPrimaryKey(SysPop record);
}