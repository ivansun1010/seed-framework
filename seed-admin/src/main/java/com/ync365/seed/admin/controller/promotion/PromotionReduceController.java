package com.ync365.seed.admin.controller.promotion;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.admin.vo.promotion.PromotionGiftVo;
import com.ync365.seed.admin.vo.promotion.PromotionGoodsVo;
import com.ync365.seed.admin.vo.promotion.PromotionReduceVo;
import com.ync365.seed.bussiness.modules.promotion.biz.PromotionBiz;

import com.ync365.seed.bussiness.modules.promotion.biz.PromotionReduceBiz;
import com.ync365.seed.bussiness.modules.promotion.entity.Promotion;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionGift;

import com.ync365.seed.bussiness.modules.promotion.entity.PromotionReduce;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionReduceReg;
import com.ync365.seed.bussiness.modules.user.entity.SysUser;
import com.ync365.seed.utils.CloneUtils;
import com.ync365.seed.utils.Constants;


/**
 * 满减的控制层
 * @author lyh
 *
 */
@Controller
@RequestMapping("/promotion/promotionReduce")
public class PromotionReduceController {
	@Autowired
	private PromotionBiz promotionBiz;
	
	@Autowired
	private PromotionReduceBiz promotionReduceBiz;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "/promotion/promotionReduce/list";
	}
	@InitBinder
	public void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}	

	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String name, PageFilter filter) {
		Grid grid = new Grid();
		List<Promotion> list = new ArrayList<Promotion>();
		long count = 9;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name);
			list = promotionBiz.searchPageByPromotionType(Constants.PromotionType.Reduce.v(), filter.getStartIndex(),
					filter.getRows());
			count = promotionBiz.searchPageCount(Constants.PromotionType.Reduce.v());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}

	/**
	 * 新增
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "/promotion/promotionReduce/add";
	}

	//添加满减活动
	@RequestMapping("/add")
	public String addPromotionReduce(PromotionReduceVo promotionReduceVo){		
		Promotion promotion = new Promotion();
		PromotionReduce promotionReduce = new PromotionReduce();
		//PromotionReduceReg promotionReduceReg = new PromotionReduceReg();
		List<PromotionReduceReg> promotionReduceRegList = new ArrayList<PromotionReduceReg>();	
		
		
		//设置活动创建人
		//promotion.setCreateUserId(sysUser.getId());	
		CloneUtils.cloneObject(promotionReduceVo, promotion);
		CloneUtils.cloneObject(promotionReduceVo, promotionReduce);		
		CloneUtils.cloneObject(promotionReduceVo, promotionReduceRegList);	
		promotionReduceBiz.create(promotion, promotionReduce, promotionReduceRegList);
		return "redirect:list";
	}
	//添加满减活动的商品
	
	
	
	//删除满减活动
	@RequestMapping("/delete")
	public String deletePromotionReduce(@RequestParam("id") int id){
		
		promotionReduceBiz.delete(id);		
		return "redirect:list";
	}
	
	//去修改满减活动页
	@RequestMapping("/editPage")
	public String editPage(String id, HttpServletRequest request) {		
		PromotionReduceVo promotionReduceVo =new PromotionReduceVo();
		PromotionReduce promotionReduce = promotionReduceBiz.selectById(Integer.parseInt(id));
		Promotion promotion = promotionBiz.selectById(Integer.parseInt(id));
			CloneUtils.cloneObject(promotion,promotionReduceVo);
			CloneUtils.cloneObject(promotionReduce,promotionReduceVo);
			request.setAttribute("promotionReduceVo",promotionReduceVo);
		return "/promotion/promotionReduce/edit";
	}
	//修改满减活动
	@RequestMapping("/edit")
	public String edit(PromotionReduceVo promotionReduceVo) {
		Promotion promotion = new Promotion();
		PromotionReduce promotionReduce = new PromotionReduce();
		
		CloneUtils.cloneObject( promotionReduceVo,promotion);
		CloneUtils.cloneObject(promotionReduceVo,promotionReduce);
		
		promotion.setPromotionType(Constants.PromotionType.Reduce.v());
		
		promotionReduceBiz.update(promotion,promotionReduce);

		
		return "/promotion/promotionReduce/list";
	}
	
/*	//满减活动列表
	@RequestMapping("/promotion/promotionReduce")
	public String getPromotionReduceList(Model model){
		List<PromotionReduce> promotionReduceList = promotionReduceBiz.findAll();
		model.addAttribute("promotionReduceList", promotionReduceList);
		return "promotion/promotionReduce/list";
	}
	*/
}
