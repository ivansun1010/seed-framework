package com.ync365.seed.bussiness.modules.promotion.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.promotion.dao.PromotionDao;
import com.ync365.seed.bussiness.modules.promotion.entity.Promotion;

@Service
public class PromotionBiz{

	private static final Logger log =Logger.getLogger(PromotionBiz.class);
	
	@Resource
	private  PromotionDao  promotionDao;
	

	/**
	 * 根据活动类型查询活动
	 * @return 
	 */
	@Transactional(readOnly = false)
	public List<Promotion> searchPageByPromotionType(int promotionType,int startIndex,int pageSize){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("promotionType", promotionType);
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return promotionDao.searchPageByPromotionType(map);
	}
	/**
	 * 根据活动类型查询活动总数
	 */
	@Transactional(readOnly = false)
	public int searchPageCount(int promotionType){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("promotionType", promotionType);
		return promotionDao.searchPageCount(map);
	}
	/**
	 * 根据活动ID获取活动信息
	 */
	public Promotion selectById(int id) {
		return promotionDao.selectById(id);
	}
	/**
	 * 校验活动开始日期是否遭遇活动结束日期
	 */
	public boolean checkStartTimeEarlyEndTime(Promotion promotion) {
		if(promotion != null){
			if(promotion.getStartTime().getTime()<promotion.getEndTime().getTime())
				return true;
			else 
				return false;
		}
		return false;
	}
}