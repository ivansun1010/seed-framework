package com.ync365.seed.bussiness.modules.goods.dao;

import com.ync365.seed.bussiness.modules.goods.entity.HoldGold;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface HoldGoldDao {
    int deleteByPrimaryKey(Long goodsId);

    int insert(HoldGold record);

    int insertSelective(HoldGold record);

    HoldGold selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(HoldGold record);

    int updateByPrimaryKey(HoldGold record);
}