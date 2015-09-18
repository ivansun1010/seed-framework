package com.ync365.seed.admin.controller.goods;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.bussiness.modules.goods.biz.BrandBiz;
import com.ync365.seed.bussiness.modules.goods.biz.BrandCategoryBiz;
import com.ync365.seed.bussiness.modules.goods.biz.CategoryBiz;
import com.ync365.seed.bussiness.modules.goods.entity.Brand;
import com.ync365.seed.bussiness.modules.goods.entity.BrandCategory;
import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.web.vo.ZTreeVo;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandBiz brandBiz;

	@Autowired
	private CategoryBiz categoryBiz;

	@Autowired
	BrandCategoryBiz brandCategoryBiz;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "goods/brandList";
	}

	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String qChName, PageFilter filter) {
		Grid grid = new Grid();
		List<Brand> list = new ArrayList<Brand>();
		long count = 0;

		try {
			list = brandBiz.searchPage(qChName, filter.getStartIndex(), filter.getRows());
			count = brandBiz.searchPageCount(qChName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
	 
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}

	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "goods/brandAdd";
	}

	@RequestMapping("/add")
	public ModelAndView add(Brand brand) {
		try {
			brand.setCreateTime(new Timestamp(System.currentTimeMillis()));
			brandBiz.addBrand(brand);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/brand/list");
	}

	@RequestMapping("/editPage")
	public String editPage(String id, HttpServletRequest request) {
		Brand brand;
		try {
			brand = brandBiz.selectById(Integer.parseInt(id));
			request.setAttribute("brand", brand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/goods/brandEdit";
	}

	@RequestMapping("/edit")
	public ModelAndView edit(Brand brand) {
		try {
			brand.setCreateTime(new Timestamp(System.currentTimeMillis()));
			brandBiz.edit(brand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/brand/list");
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		try {
			brandBiz.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/brand/list");
	}

	@RequestMapping("/brandCategory")
	public String brandCategory(@RequestParam("brandId") int brandId,
			HttpServletRequest request) {
		request.setAttribute("brandId", brandId);
		return "/goods/brandCategory";
	}

	@RequestMapping("/getCategoryTree")
	@ResponseBody
	public List<ZTreeVo> getCategoryTree(HttpServletRequest request,
			Integer brandId) {
		List<ZTreeVo> list = new ArrayList<ZTreeVo>();
		try {
			List<Category> categoryList = categoryBiz.selectCategoryAll();
			for (Category c : categoryList) {
				ZTreeVo vo = new ZTreeVo();
				vo.setId(String.valueOf(c.getCategoryId()));
				vo.setName(c.getName());
				vo.setpId(String.valueOf(c.getParentId()));
				list.add(vo);

			}

			List<BrandCategory> bcList = brandCategoryBiz
					.searchBrandCategoryList(brandId);
			if (bcList != null && bcList.size() > 0) {
				for (BrandCategory bc : bcList) {
					for (ZTreeVo t : list) {
						if (String.valueOf(bc.getCategoryId())
								.equals(t.getId())) {
							System.out.println("------------------"
									+ t.getId().equals(bc.getCategoryId()));
							t.setChecked(true);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/addBrandCategory")
	@ResponseBody
	public ModelAndView addBrandCategory(int brandId, String categoryIds) {

		try {
			if (StringUtils.isNotBlank(categoryIds)) {
				brandCategoryBiz.addBrandCategorys(brandId, categoryIds);
			} else {
				brandCategoryBiz.deleteById(brandId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/brand/list");
	}
}