package com.ync365.seed.bussiness.modules.user.dao;

import com.ync365.seed.bussiness.modules.user.entity.SysPopStoreBrandRelationship;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysPopStoreBrandRelationshipMapper {
    int insert(SysPopStoreBrandRelationship record);

    int insertSelective(SysPopStoreBrandRelationship record);
}