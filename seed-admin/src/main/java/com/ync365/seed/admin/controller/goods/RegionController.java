package com.ync365.seed.admin.controller.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.bussiness.modules.common.biz.RegionBiz;
import com.ync365.seed.bussiness.modules.common.entity.Region;
@Controller
@RequestMapping("/region")
public class RegionController {

	@Autowired
	private RegionBiz regionBiz;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "goods/regionList";
	}

	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String qName, PageFilter filter) {
		Grid grid = new Grid();
		List<Region> list = new ArrayList<Region>();
		long count = 0;
		try {
			list = regionBiz.searchPage(qName, filter.getStartIndex(), filter.getRows());
			//System.out.println(list.toString());
			count = regionBiz.searchPageCount(qName);
			//System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}

	/* 跳转到添加页面 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		/**
		 * 一二级地区的添加需要完善
		 */
		return "/goods/regionAdd";
	}

	// 新增
	@RequestMapping("/add")
	public ModelAndView add(Region region) {
		int temp = 0;
		boolean flag = false;
		try {
			temp = regionBiz.add(region);
			if (temp != 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/region/list");
	}

	/* 跳转到编辑页面 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Integer id) {
		Region region;
		try {
			region = regionBiz.selectById(id);
			request.setAttribute("region", region);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "goods/regionEdit";
	}

	/**
	 * 编辑
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(Region region) {
		boolean flag=false;
		try {
			int result = regionBiz.edit(region);
			if (result == 1) {
				 flag=true;
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return new ModelAndView("redirect:/region/list");
	}
	// 删除
//	@RequestMapping("/delete")
//	public ModelAndView delete(HttpServletRequest reques,
//			@RequestParam("id") int id) {
//		int temp = 0;
//		boolean flag = false;
//		try {
//			temp = regionBiz.deleteById(id);
//			if (temp != 0) {
//				flag = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ModelAndView("redirect:/feature/list");
//	}
}
