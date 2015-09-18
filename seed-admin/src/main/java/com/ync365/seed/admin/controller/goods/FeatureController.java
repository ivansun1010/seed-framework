package com.ync365.seed.admin.controller.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.admin.vo.goods.FeatureVo;
import com.ync365.seed.bussiness.modules.goods.biz.CategoryBiz;
import com.ync365.seed.bussiness.modules.goods.biz.FeatureBiz;
import com.ync365.seed.bussiness.modules.goods.dao.FeatureValueDao;
import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.FeatureValue;

@Controller
@RequestMapping("/feature")
public class FeatureController {

	@Autowired
	private FeatureBiz featureBiz;
	
	@Autowired
	private CategoryBiz categoryBiz;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "goods/featureList";
	}

	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String qName, PageFilter filter) {
		Grid grid = new Grid();
		List<Feature> list = new ArrayList<Feature>();
		long count = 0;
		try {
			list = featureBiz.searchPage(qName, filter.getStartIndex(), filter.getRows());
			//System.out.println(list.toString());
			count = featureBiz.searchPageCount(qName);
			//System.out.println(count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());;
		return grid;
	}

	@RequestMapping("/getfeature")
	@ResponseBody
	public List<Feature> getFeature(Integer CategoryId) {
		List<Feature> feature = featureBiz.getFeaturesBySpecAndCategoryId(1, CategoryId);
		return feature;
	}

	/* 跳转到添加页面 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "/goods/featureAdd";
	}

	// 新增
	@RequestMapping("/add")
	public ModelAndView add(Feature  feature , FeatureVo vo  ) {
		int temp = 0;
		boolean flag = false;
		try {
			temp = featureBiz.add(feature,vo.getfVList());
			
			if (temp != 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/feature/list");
	}

	/* 跳转到编辑页面 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Integer id) {

		Feature feature = new Feature();
		Category category = null;
		List<FeatureValue> fVList = null;
		try {
			if (id != null) {
				feature = featureBiz.selectById(id);
				category = categoryBiz.selectByPrimaryKey(feature.getCategoryId());
				fVList = featureBiz.getFeatureValueByFeatureId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//parentFeature要查出来
		List<Feature> parentFeatureList = featureBiz.getParentFeatures();
		request.setAttribute("parentFeatureList", parentFeatureList);
		request.setAttribute("feature", feature);
		request.setAttribute("categroyName", category.getName());
		request.setAttribute("fVList", fVList);
		return "goods/featureEdit";
	}

	/**
	 * 编辑
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(Feature feature,FeatureVo vo) {
		boolean flag=false;
		try {
			int result = featureBiz.edit(feature,vo.getfVList());
			if (result == 1) {
				 flag=true;
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return new ModelAndView("redirect:/feature/list");
	}
	
	/* 跳转到添加属性值页面 */
	@RequestMapping("/addValuePage")
	public String addValuePage(HttpServletRequest request, Integer id) {
		return "goods/attr_values";
	}
	

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest reques,
			@RequestParam("id") int id) {
		int temp = 0;
		boolean flag = false;
		try {
			temp = featureBiz.deleteById(id);
			if (temp != 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/feature/list");
	}
}
