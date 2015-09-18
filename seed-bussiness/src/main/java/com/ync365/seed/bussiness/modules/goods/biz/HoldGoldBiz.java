package com.ync365.seed.bussiness.modules.goods.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.goods.dao.HoldGoldDao;
import com.ync365.seed.bussiness.modules.goods.entity.HoldGold;

@Service
public class HoldGoldBiz {

	@Autowired
	HoldGoldDao holdGoldDao ;
	
	public HoldGold selectByPrimaryKey(Long goodsId){
		
		return holdGoldDao.selectByPrimaryKey(goodsId);
	}
}
