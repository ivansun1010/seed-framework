package com.ync365.seed.bussiness.modules.promotion.biz;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;



import com.ync365.seed.bussiness.modules.promotion.entity.PromotionGiftGoods;
import com.ync365.seed.bussiness.modules.promotion.dao.PromotionGiftGoodsDao;





@Service
public class PromotionGiftGoodsBiz{

	private static final Logger log =Logger.getLogger(PromotionGiftGoodsBiz.class);
	
	@Resource
	private  PromotionGiftGoodsDao  promotionGiftGoodsDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PromotionGiftGoods 
	 */
	public PromotionGiftGoods find(Serializable id){
		return promotionGiftGoodsDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PromotionGiftGoods> 
	 */
	public List<PromotionGiftGoods> findAll(){
		return promotionGiftGoodsDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PromotionGiftGoods po) throws Exception{
		
			if( po != null )
				 promotionGiftGoodsDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PromotionGiftGoods po) throws Exception{

			if( po != null )
				 promotionGiftGoodsDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 promotionGiftGoodsDao.delete(id);
	}

}