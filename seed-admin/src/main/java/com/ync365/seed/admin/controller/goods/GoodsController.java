package com.ync365.seed.admin.controller.goods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.admin.vo.goods.GoodsVo;
import com.ync365.seed.bussiness.modules.common.biz.RegionBiz;
import com.ync365.seed.bussiness.modules.common.entity.Region;
import com.ync365.seed.bussiness.modules.goods.biz.BrandBiz;
import com.ync365.seed.bussiness.modules.goods.biz.CategoryBiz;
import com.ync365.seed.bussiness.modules.goods.biz.FeatureBiz;
import com.ync365.seed.bussiness.modules.goods.biz.GoodsBiz;
import com.ync365.seed.bussiness.modules.goods.biz.HoldGoldBiz;
import com.ync365.seed.bussiness.modules.goods.biz.PicInfoBiz;
import com.ync365.seed.bussiness.modules.goods.dao.BlobDao;
import com.ync365.seed.bussiness.modules.goods.entity.Blob;
import com.ync365.seed.bussiness.modules.goods.entity.Brand;
import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.Goods;
import com.ync365.seed.bussiness.modules.goods.entity.HoldGold;
import com.ync365.seed.bussiness.modules.goods.entity.PicInfo;
import com.ync365.seed.commons.mapper.JsonMapper;
import com.ync365.seed.web.vo.ZTreeVo;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsBiz goodsBiz;
	@Autowired
	private FeatureBiz featureBiz;
	@Autowired
	private BrandBiz brandBiz;
	@Autowired
	private CategoryBiz categoryBiz;
	@Autowired
	private PicInfoBiz picInfoBiz;
	
	@Autowired
	private HoldGoldBiz holdGoldBiz ;
	
	@Autowired
	private RegionBiz regionBiz;
	
	@Autowired
	private BlobDao blobDao;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		//请求品牌数据
		List<Brand> brandList = brandBiz.getAllbrandList();
		request.setAttribute("brandList",brandList);
		return "goods/goodsList";
	}

	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String name, String code,String categoryId,String goodsbrandId,PageFilter filter, String keywords, String isNew,Model model) {
		Grid grid = new Grid();
		List<Goods> list = new ArrayList<Goods>();
		long count = 9;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("code", code);
			//搜索分类
			if(null != categoryId && "" != categoryId){
				map.put("categoryId", Integer.parseInt(categoryId));
			}
			//搜索品牌
			if(null != goodsbrandId && "" != goodsbrandId){
				map.put("brandId", Integer.parseInt(goodsbrandId));
			}
			 
			list = goodsBiz.selectPage(map, filter.getStartIndex(), filter.getRows());
			count = goodsBiz.selectPageCount(map);
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}

	@RequestMapping("/addPage")
	public String addPage(Model model) {
		List<Brand> brandList = brandBiz.getAllbrandList();
		model.addAttribute("brandList",brandList);
		
		List<Region> regionList = regionBiz.selectByLevel() ;
		model.addAttribute("regionList", regionList);
		
		return "/goods/goodsAdd";
	}
	
	@RequestMapping("/add")
	public String insert(GoodsVo vo) {
		vo.getGoods().setCreateTime(Calendar.getInstance().getTime());
		goodsBiz.addGoods(vo.getGoods(), vo.getHoldGold(),vo.getBlob());
		return "redirect:list";
	}
	
	
	@RequestMapping("/getCategoryByBrandId")
	@ResponseBody
	public List<Category> getCategoryByBrandId(Integer brandId){
		List<Category> categoryList = categoryBiz.getCategoryByBrandId(brandId);
		return categoryList;
	}
	
	@RequestMapping("/getCategoryTreeByBrandId")
	@ResponseBody
	public List<ZTreeVo> getCategoryByParentId(Integer brandId){
		List<ZTreeVo> list=new ArrayList<ZTreeVo>();
		List<Category> categoryList = null;
		if(brandId == null ){
			categoryList = categoryBiz.selectCategoryAll() ;
		}else {
			categoryList = categoryBiz.getCategoryByBrandId(brandId);
		}
		for(Category category:categoryList){
			ZTreeVo zTreeVo = new ZTreeVo();
			zTreeVo.setId(category.getCategoryId().toString());
			zTreeVo.setName(category.getName());
			zTreeVo.setpId(category.getParentId().toString());
			list.add(zTreeVo);
		}
		return list;
	}
	

	@RequestMapping("/editPage")
	public String show(Model model, @RequestParam("goodId") Integer goodId) {
		
		//前台展示Vo
		GoodsVo goodView = new GoodsVo();
		Goods good = goodsBiz.selectByPrimaryKey(goodId);
		
		//查询除输入属性的所有属性列表
		List<Feature> listFeatures = featureBiz.getFeaturesByCategoryId(good
				.getCategoryId());
		goodView.setGoods(good);
		goodView.setFeatures(listFeatures);
		
		//拥金
		HoldGold holdGold = holdGoldBiz.selectByPrimaryKey(Long.parseLong(String.valueOf(goodId) ));
		goodView.setHoldGold(holdGold);
		
		//区域
		List<Region> regionList = regionBiz.selectByLevel() ;
		model.addAttribute("regionList", regionList);
		
		JsonMapper js=new JsonMapper();
		String str=js.toJson(listFeatures);
		model.addAttribute("model", goodView);
		model.addAttribute("json",str);
		
		//查询所有商品对应的规格属性集合
		List<Feature> featuresList = goodsBiz.selectFeaturesIdByGoodsId(goodId,1);
		model.addAttribute("featuresList",featuresList);
		// model.addAttribute("listFeature", listFeature);
		
		//分类
		List<Category> categoryList = categoryBiz.getCategoryByBrandId(good.getBrandId());
		
		//品牌
		List<Brand> brandList = brandBiz.getAllbrandList();
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("brandList",brandList);
		
		//图片
		PicInfo picInfo = new PicInfo();
		picInfo.setUuid(good.getUuid());
		List<PicInfo> picInfoList = picInfoBiz.selectByPicInfo(picInfo);
		model.addAttribute("picInfoList",picInfoList);
		
		//详情
		Blob blob=blobDao.selectByPrimaryKey(goodId);
		goodView.setBlob(blob);
		return "/goods/goodsEdit";
	}

	

	@RequestMapping("/edit")
	public String edit(GoodsVo view) {
		view.getGoods().setCreateTime(Calendar.getInstance().getTime());
		goodsBiz.updateGoodsAndSku(view.getGoods(),view.getBlob());
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(Integer goodId) {
		goodsBiz.deleteByPrimaryKey(goodId);
		return "redirect:list";
	}

	@RequestMapping("/getFeatureByCategoryId")
	@ResponseBody
	public List<Feature> getFeatureByCategoryId(
			@RequestParam("categoryId") Integer categoryId) {
		List<Feature> listFeature = featureBiz
				.getFeaturesByCategoryId(categoryId);
		return listFeature;
	}
	
}
