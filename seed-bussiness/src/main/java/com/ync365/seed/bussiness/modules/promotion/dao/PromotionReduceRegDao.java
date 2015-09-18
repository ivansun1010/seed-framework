package com.ync365.seed.bussiness.modules.promotion.dao;

import com.ync365.seed.bussiness.modules.promotion.entity.Promotion;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionReduceReg;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface PromotionReduceRegDao {
    int insert(PromotionReduceReg record);
    int insertSelective(PromotionReduceReg record);
    //int updateByPrimaryKeySelective(PromotionReduceReg record);
    int deleteByPrimaryKey(Integer Id);
}