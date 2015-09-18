package com.ync365.seed.bussiness.modules.goods.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ync365.seed.bussiness.modules.goods.dao.BlobDao;
import com.ync365.seed.bussiness.modules.goods.dao.GoodsDao;
import com.ync365.seed.bussiness.modules.goods.dao.HoldGoldDao;
import com.ync365.seed.bussiness.modules.goods.dao.SkuDao;
import com.ync365.seed.bussiness.modules.goods.dao.SkuFeatureDao;
import com.ync365.seed.bussiness.modules.goods.entity.Blob;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.Goods;
import com.ync365.seed.bussiness.modules.goods.entity.HoldGold;
import com.ync365.seed.bussiness.modules.goods.entity.Sku;
import com.ync365.seed.bussiness.modules.goods.entity.SkuFeature;
import com.ync365.seed.utils.DateUtils;
import com.ync365.seed.utils.StringUtils;

@Service
public class GoodsBiz {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private SkuDao skuDao;

	@Autowired
	private SkuFeatureDao skuFeatureDao;
	
	@Autowired
	private HoldGoldDao holdGoldDao ;
	
	@Autowired
	private BlobDao blobDao;
	/**
	 * 功能描述:添加 商品 和 sku
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	@Transactional
	public int addProductAndSku(Goods goods) {
		int n = goodsDao.insert(goods);
		addSkusByGoods(goods);
		return n;
	}
	
	@Transactional
	public int addGoods(Goods goods,HoldGold holdGold ,Blob blod){
		int n = goodsDao.insert(goods) ;
		addSkusByGoods(goods);
		if(holdGold != null ){
			holdGold.setGoodsId(goods.getGoodsId());
			n=holdGoldDao.insert(holdGold);
		}
		
		if(blod!=null){
			blod.setGoodsId(goods.getGoodsId());
			n=blobDao.insert(blod);
		}
		return n;
	}

	private void addSkusByGoods(Goods goods) {
		List<Sku> skuList = goods.getSkus();
		if (skuList == null || skuList.isEmpty()) {
			return;
		}

		for (int i = 0; i < skuList.size(); i++) {
			Sku sku = skuList.get(i);

			sku.setGoodsId(goods.getGoodsId());
			/** 启用 */
			sku.setStatus(1);
			sku.setCreateTime(DateUtils.stringToDate(DateUtils.getSystemTime(),
					"yyyy-MM-dd HH:mm:ss"));
			sku.setOptDate(DateUtils.stringToDate(DateUtils.getSystemTime(),
					"yyyy-MM-dd HH:mm:ss"));
			if (!StringUtils.isNotEmpty(sku.getSku())) {
				continue;
			}
			 
			skuDao.insert(sku);
			
			//规格 
			for (SkuFeature sf : sku.getSkuFeatures()) {
				sf.setIsSpec(1);
			}
			
			//非规格
			if(goods.getSkuFeatures()!=null){
				sku.getSkuFeatures().addAll(goods.getSkuFeatures());
			}
			List<SkuFeature> skuFeatureList = sku.getSkuFeatures();
			if (skuFeatureList != null && !skuFeatureList.isEmpty()) {
				for (SkuFeature skuFeature : skuFeatureList) {
					skuFeature.setSkuId(sku.getSkuId());
					if (skuFeature.getFeatureId() != null
							&& skuFeature.getFeatureId() > 0
							&& StringUtils.isNotEmpty(skuFeature.getSpecValue())) {
						skuFeature.setTid(null);
						skuFeatureDao.insert(skuFeature);
					}
				}
			}
			
			 
			

		}
	}

	/**
	 * 功能描述:修改 商品 和 sku
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	@Transactional
	public int updateGoodsAndSku(Goods goods,Blob blob) {
		int n = goodsDao.updateByPrimaryKeySelective(goods);
		blob.setGoodsId(goods.getGoodsId());
		n=blobDao.updateByPrimaryKeySelective(blob);
		if (goods.getSkus() == null || goods.getSkus().isEmpty()) {
			return 0;
		}
		
		for (Sku sku : goods.getSkus()) {
			if(sku==null){
				continue;
			}
			if (sku.getSkuId()==null||sku.getSkuId() == 0) {
				//原来为物理删除改为逻辑删除
				deleteSkuAndFeatureByGoodId(goods.getGoodsId());
				addSkusByGoods(goods);
			} else {
				sku.setOptDate(DateUtils.stringToDate(DateUtils.getSystemTime(),
						"yyyy-MM-dd HH:mm:ss"));
				skuDao.updateByPrimaryKey(sku);
				if (sku.getSkuFeatures() != null
						&& !sku.getSkuFeatures().isEmpty()) {
					for (SkuFeature skuFeature : sku.getSkuFeatures()) {
						skuFeatureDao.updateByPrimaryKeySelective(skuFeature);
					}
				}
				if(goods.getSkuFeatures()!=null){
					for(SkuFeature skuFeature:goods.getSkuFeatures()){
						if(skuFeature.getSpecValue()!=null&&!"".equals(skuFeature.getSpecValue())){
							skuFeature.setSkuId(sku.getSkuId());
							if(skuFeature.getTid()!=null){
								skuFeatureDao.updateByPrimaryKeySelective(skuFeature);
							}else{
								skuFeatureDao.insert(skuFeature);
							}
						}else{
							if(skuFeature.getTid()!=null){
								//逻辑删除方法，待关凤亮提交代码后再写入
								skuFeatureDao.deleteByPrimaryKey(skuFeature.getTid());
							}
						}
					}
				}
			}
		}

		return n;
	}

	/**
	 * 
	 * 功能描述:根据商品id查询SKU
	 * 
	 * @date 2015年7月30日13:23:36
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public List<Sku> selectSKUByProductId(Integer goodsId) {
		return skuDao.selectByGoodsId(goodsId);
	}

	/**
	 * 功能描述:商品添加
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int add(Goods goods) {
		return goodsDao.insert(goods);
	}

	/**
	 * 功能描述:商品修改
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int update(Goods goods) {
		return goodsDao.updateByPrimaryKeySelective(goods);
	}

	/**
	 * 功能描述:商品SKU修改
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int updateByProductId(Sku sku) {
		return skuDao.updateByGoodsId(sku);
	}

	/**
	 * 
	 * 功能描述:分页查询
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public List<Goods> selectPage(Map<String, Object> map, int startIndex,
			int pageSize) {
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return goodsDao.selectPage(map);
	}

	/**
	 * 
	 * 功能描述:统计总记录数
	 * 
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int selectPageCount(Map<String, Object> map) {
		return goodsDao.selectPageCount(map);
	}

	/**
	 * 
	 * 功能描述:根据商品id查询商品信息
	 * 
	 * @date 2015年7月30日13:23:36
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public Goods selectByPrimaryKey(int productId) {
		Goods good = goodsDao.selectByPrimaryKey(productId);
		List<Sku> listSkus = skuDao.selectByGoodsId(productId);
		for (Sku sku : listSkus) {
			List<SkuFeature> listSkuFeatures = selectPruFeatureBySkuId(Long
					.valueOf(sku.getSkuId()));
			List<SkuFeature> listSpecFeatures = new ArrayList<SkuFeature>();
			List<SkuFeature> listGoodsFeatures = new ArrayList<SkuFeature>();
			for (SkuFeature skuFeature : listSkuFeatures) {
				if (skuFeature.getIsSpec() == 1) {
//					Feature feature = new Feature();
//					HashMap<String, String> map = new HashMap<String, String>();
//					map.put("featureId", skuFeature.getFeatureId()==null||"".equals(skuFeature.getFeatureId())?"0":skuFeature.getFeatureId().toString());
//					feature.setFeatureValues(featureValueMapper.selectFeatureListByMap(map));
//					skuFeature.setFeature(feature);
					listSpecFeatures.add(skuFeature);
				} else {
					listGoodsFeatures.add(skuFeature);
				}
			}
			sku.setSkuFeatures(listSpecFeatures);
			good.setSkuFeatures(listGoodsFeatures);
		}

		good.setSkus(listSkus);

		return good;
	}

	/**
	 * 
	 * 功能描述:保存商品SKU
	 * 
	 * @date 2015年7月31日09:18:43
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int insert(Sku record) {
		return skuDao.insert(record);
	}

	/**
	 * 
	 * 功能描述:根据编号修改商品SKU
	 * 
	 * @date 2015年7月31日09:18:43
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int updateByPrimaryKeySelective(Sku record) {
		return skuDao.updateByPrimaryKeySelective(record);
	}

	/**
	 * 
	 * 功能描述:根据编号删除商品SKU
	 * 
	 * @date 2015年7月31日09:18:43
	 * @return
	 * @version 1.0.0
	 * @author 贾昌强
	 */
	public int deleteByPrimaryKey(Integer goodid) {
		deleteSkuAndFeatureByGoodId(goodid);
		return goodsDao.deleteByPrimaryKey(Long.valueOf(goodid));
	}

	/**逻辑删除
	 * 
	 * sku已经逻辑删除，skuFeature查询是根据skuid的，所有
	 * 无需在删除skuFeature
	 * 
	 * @param goodid
	 */
	private void deleteSkuAndFeatureByGoodId(Integer goodid) {
		skuDao.deleteByPrimaryKey(goodid);
	}

	public List<SkuFeature> selectPruFeatureBySkuId(Long skuId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("skuId", skuId);
		return skuFeatureDao.selectListBySkuId(map);
	}

	public List<Map<String, Object>> selectAllFeaturesBySkuId(
			List<Long> skuIdList, int isSpec) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listIds", skuIdList);
		map.put("isSpec", isSpec);
		return skuFeatureDao.selectAllFeaturesBySkuId(map);
	}

	/**
	 * 根据goodsId查询商品下的所有属性id以及属性值
	 * @author xieang
	 * 2015年8月26日
	 * @param goodsId
	 * @param isSpec
	 * @return
	 */
	public List<Feature> selectFeaturesIdByGoodsId(Integer goodsId,Integer isSpec){
		List<Feature> featureList = skuFeatureDao.selectFeaturesIdByGoodsId(goodsId, isSpec);
		return featureList;
	}
}
