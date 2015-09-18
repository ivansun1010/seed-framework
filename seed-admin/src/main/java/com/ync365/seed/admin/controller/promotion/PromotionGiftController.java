package com.ync365.seed.admin.controller.promotion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.admin.vo.promotion.PromotionGiftVo;
import com.ync365.seed.bussiness.modules.promotion.biz.PromotionBiz;
import com.ync365.seed.bussiness.modules.promotion.biz.PromotionGiftBiz;
import com.ync365.seed.bussiness.modules.promotion.entity.Promotion;
import com.ync365.seed.bussiness.modules.promotion.entity.PromotionGift;
import com.ync365.seed.bussiness.modules.user.biz.SysAdminBiz;
import com.ync365.seed.utils.CloneUtils;
import com.ync365.seed.utils.Constants;

@Controller
@RequestMapping("/promotionGift")
public class PromotionGiftController {

	@Autowired
	private PromotionGiftBiz promotionGiftBiz;

	@Autowired
	private PromotionBiz promotionBiz;


	

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "/promotion/promotionGift/promotionGiftList";
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
			list = promotionBiz.searchPageByPromotionType(Constants.PromotionType.Gift.v(), filter.getStartIndex(),
					filter.getRows());
			count = promotionBiz.searchPageCount(Constants.PromotionType.Gift.v());

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
		return "/promotion/promotionGift/promotionGiftAdd";
	}

	// 新增
	@RequestMapping("/add")
	public ModelAndView add(PromotionGiftVo promotionGiftVo, Errors errors) {
		Promotion promotion = new Promotion();
		PromotionGift promotionGift = new PromotionGift();
		
		//数据校验
		
		
//		if (!promotionBiz.checkStartTimeEarlyEndTime(promotion)) {
//			errors.rejectValue("startTime", "活动开始时间不能早于活动结束时间");
//			
//		}
		//补充数据
		
		promotionGiftVo.setCreateTime(new Date());;
		promotionGiftVo.setPromotionType(Constants.PromotionType.Gift.v());
		promotionGiftVo.setIsDelete(Constants.Whether.No.v());
		promotionGiftVo.setIsAllUser(Constants.Whether.Yes.v());
		promotionGiftVo.setIsAllSku(Constants.Whether.Yes.v());
		promotionGiftVo.setStatus(Constants.PromotionStatus.New.v());
		//TODO
		promotionGiftVo.setCreateUserId("test");
		
		CloneUtils.cloneObject( promotionGiftVo,promotion);
		CloneUtils.cloneObject(promotionGiftVo,promotionGift);
		
		//设置活动类型
		promotionGiftBiz.create(promotion,promotionGift);
		return new ModelAndView("redirect:/promotionGift/list");
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteById(@RequestParam("id") int id) {
			promotionGiftBiz.deleteById(id);
		return new ModelAndView("redirect:/promotionGift/list");
		
	} 
	
	@RequestMapping("/editPage")
	public String editPage(String id, HttpServletRequest request) {
		Promotion promotion;
		PromotionGift promotionGift;
		PromotionGiftVo promotionGiftVo =new PromotionGiftVo();
			promotionGift = promotionGiftBiz.selectById(Integer.parseInt(id));
			promotion = promotionBiz.selectById(Integer.parseInt(id));
			CloneUtils.cloneObject(promotion, promotionGiftVo);
			CloneUtils.cloneObject(promotionGift,promotionGiftVo);
			request.setAttribute("promotionGiftVo", promotionGiftVo);
		return "/promotion/promotionGift/promotionGiftEdit";
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(PromotionGiftVo promotionGiftVo) {
		Promotion promotion = new Promotion();
		PromotionGift promotionGift = new PromotionGift();
		
		CloneUtils.cloneObject( promotionGiftVo,promotion);
		CloneUtils.cloneObject(promotionGiftVo,promotionGift);
		
		promotion.setPromotionType(Constants.PromotionType.Gift.v());
		
		promotionGiftBiz.update(promotion,promotionGift);

		
		return new ModelAndView("redirect:/promotionGift/list");
	}


}
