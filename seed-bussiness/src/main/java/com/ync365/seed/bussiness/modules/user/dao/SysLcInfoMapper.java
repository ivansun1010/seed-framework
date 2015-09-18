package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysLcInfo;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysLcInfoMapper {
    int insert(SysLcInfo record);

    int insertSelective(SysLcInfo record);
}