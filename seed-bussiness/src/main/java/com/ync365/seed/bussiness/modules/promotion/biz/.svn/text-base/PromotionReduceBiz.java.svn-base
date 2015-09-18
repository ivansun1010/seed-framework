package com.ync365.seed.bussiness.modules.promotion.biz;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.promotion.dao.PromotionDao;
import com.ync365.seed.bussiness.modules.promotion.dao.PromotionReduceDao;
import com.ync365.seed.bussiness.modules.promotion.dao.PromotionReduceRegDao;
import com.ync365.seed.bussiness.modules.promotion.entity.Promotion;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionReduce;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionReduceReg;
import com.ync365.seed.utils.Constants;





@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PromotionReduceBiz{

	private static final Logger log =Logger.getLogger(PromotionReduceBiz.class);
	
	@Resource
	private  PromotionDao  promotionDao;
	
	@Resource
	private  PromotionReduceDao  promotionReduceDao;
	
	@Resource
	private  PromotionReduceRegDao  promotionReduceRegDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PromotionReduce 
	 */
	public PromotionReduce find(Integer promotionId){
		return promotionReduceDao.selectByPrimaryKey(promotionId);	
	}

	
	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(readOnly = false)
	public void create(Promotion promotion,PromotionReduce promotionReduce,List<PromotionReduceReg> promotionReduceRegList){
		//设置活动类型为满减
		promotion.setPromotionType(Constants.PromotionType.Reduce.v());
		//设置活动创建时间
		promotion.setCreateTime(new Date());
		//设置活动状态
		promotion.setStatus(Constants.Status.Enabled.v());
		//保存活动
		promotionDao.insert(promotion);
		promotionReduce.setPromotionId(promotion.getPromotionId());
		//保存满减活动
		promotionReduceDao.insert(promotionReduce);
		//遍历活动规则
		if(promotionReduceRegList != null && promotionReduceRegList.size() > 0){
			for(PromotionReduceReg promotionReduceReg : promotionReduceRegList){
				promotionReduceReg.setPromotionId(promotion.getPromotionId());
				//保存活动规则
				promotionReduceRegDao.insert(promotionReduceReg);
			}
		}
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional(readOnly = false)
	public void update(PromotionReduce po) {

			if( po != null )
				 promotionReduceDao.updateByPrimaryKeySelective(po);

	}
	
	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional(readOnly = false)
	public void delete(Integer promotionId) {
		 //删除满减活动规则
		 promotionReduceRegDao.deleteByPrimaryKey(promotionId);
		 //删除满减活动
		 promotionReduceDao.deleteByPrimaryKey(promotionId);
		 //删除活动
		 promotionDao.deleteByPrimaryKey(promotionId);
	}
	/**
	 * 添加满减活动的商品
	 */
	@Transactional(readOnly = false)
	public void addPromotionReduceGoods(PromotionReduce proReduce,Integer promotionId,String goodsIds){
		
		
	}
	/**
	 * 根据活动ID获取活动信息
	 */
	public PromotionReduce selectById(Integer promotionId) {
		return promotionReduceDao.selectByPrimaryKey(promotionId);
	}


	public void update(Promotion promotion, PromotionReduce promotionReduce) {
		if (promotion.getPromotionId() != null){			
			promotionDao.updateByPrimaryKeySelective(promotion);
		}
		promotionReduce.setPromotionId(promotion.getPromotionId());
		if (promotionReduce.getPromotionId() != null){
			promotionReduceDao.updateByPrimaryKeySelective(promotionReduce);
		}
			
	}
}