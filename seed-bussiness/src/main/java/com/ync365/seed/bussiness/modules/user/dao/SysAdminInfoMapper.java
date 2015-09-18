package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysAdminInfo;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysAdminInfoMapper {
    int insert(SysAdminInfo record);

    int insertSelective(SysAdminInfo record);
}