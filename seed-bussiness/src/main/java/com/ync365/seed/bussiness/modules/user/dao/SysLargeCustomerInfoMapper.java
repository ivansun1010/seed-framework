package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysLargeCustomerInfo;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysLargeCustomerInfoMapper {
    int insert(SysLargeCustomerInfo record);

    int insertSelective(SysLargeCustomerInfo record);
}