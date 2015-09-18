package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.goods.entity.Goods;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface GoodsDao {
	
	int deleteByPrimaryKey(Long goodsId);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer productId);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);

	public List<Goods> selectPage(Map<String, Object> map);// 产品管理的分页查询功能

	public int selectPageCount(Map<String, Object> map);
}