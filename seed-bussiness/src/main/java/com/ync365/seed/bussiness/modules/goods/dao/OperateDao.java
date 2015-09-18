package com.ync365.seed.bussiness.modules.goods.dao;

import com.ync365.seed.bussiness.modules.goods.entity.Operate;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface OperateDao {
    int deleteByPrimaryKey(Long goodsId);

    int insert(Operate record);

    int insertSelective(Operate record);

    Operate selectByPrimaryKey(Integer skuId);

    int updateByPrimaryKeySelective(Operate record);

    int updateByPrimaryKey(Operate record);
}