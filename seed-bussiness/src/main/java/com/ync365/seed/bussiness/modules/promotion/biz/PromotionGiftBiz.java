package com.ync365.seed.bussiness.modules.promotion.biz;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.promotion.dao.PromotionDao;
import com.ync365.seed.bussiness.modules.promotion.dao.PromotionGiftDao;
import com.ync365.seed.bussiness.modules.promotion.entity.Promotion;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionGift;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PromotionGiftBiz {

	private static final Logger log = Logger.getLogger(PromotionGiftBiz.class);

	@Resource
	private PromotionGiftDao promotionGiftDao;

	@Resource
	private PromotionDao promotionDao;


	/**
	 * 创建同时添加增加活动主表和满减活动表
	 * 
	 * @param po
	 */
	@Transactional(readOnly = false)
	public void create(Promotion promotion, PromotionGift po) {

		if (promotion != null)
			promotionDao.insert(promotion);
		po.setPromotionId(promotion.getPromotionId());
		if (po != null)
			promotionGiftDao.insert(po);
	}

	/**
	 * 删除同时添加增加活动主表和满减活动表
	 * 
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void deleteById(int id) {
			promotionDao.deleteByPrimaryKey(id);
			promotionGiftDao.deleteByPrimaryKey(id);
	}
	/**
	 * 查找当个满赠活动信息
	 */
	public PromotionGift selectById(int id) {
		return promotionGiftDao.selectByPrimaryKey(id);
	}
	@Transactional(readOnly = false)
	public void update(Promotion promotion, PromotionGift po) {

		if (promotion != null)
			promotionDao.updateByPrimaryKeySelective(promotion);
		po.setPromotionId(promotion.getPromotionId());
		if (po != null)
			promotionGiftDao.updateByPrimaryKeySelective(po);

	}

}