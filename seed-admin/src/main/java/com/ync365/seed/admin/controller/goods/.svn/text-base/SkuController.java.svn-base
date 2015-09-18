package com.ync365.seed.admin.controller.goods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.Json;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.bussiness.modules.goods.biz.SkuBiz;
import com.ync365.seed.bussiness.modules.goods.dao.SkuDao;
import com.ync365.seed.bussiness.modules.goods.entity.Category;
import com.ync365.seed.bussiness.modules.goods.entity.Feature;
import com.ync365.seed.bussiness.modules.goods.entity.Sku;
import com.ync365.seed.utils.StringUtils;

@Controller
@RequestMapping("/sku")
public class SkuController {
	
	@Autowired
	private SkuBiz skuBiz;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "goods/skuList";
	}

	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String name, PageFilter filter) {
		Grid grid = new Grid();
		List<Sku> list = new ArrayList<Sku>();
		long count = 0;
		Map<String ,Object> map=new HashMap<String,Object>();
		try {
			map.put("name", name);
			list=skuBiz.searchPage(map, filter.getStartIndex(),filter.getRows());
			count = skuBiz.searchPageCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}
	
	/**
	 * 商品审核
	 * @param request
	 * @return
	 */
	@RequestMapping("/auditList")
	public String auditList(HttpServletRequest request) {
		return "goods/auditList";
	}

	@RequestMapping("/auditGrid")
	@ResponseBody
	public Grid auditDataGrid(String name, PageFilter filter) {
		Grid grid = new Grid();
		List<Sku> list = new ArrayList<Sku>();
		long count = 0;
		Map<String ,Object> map=new HashMap<String,Object>();
		try {
			map.put("name", name);
			list=skuBiz.searchAuditPage(map, filter.getStartIndex(),filter.getRows());
			count = skuBiz.searchPageCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}
	
	
	/**
	 * 商品上下架
	 * @param request
	 * @return
	 */
	@RequestMapping("/releaseList")
	public String releaseList(HttpServletRequest request) {
		return "goods/releaseList";
	}

	@RequestMapping("/releaseGrid")
	@ResponseBody
	public Grid releaseDataGrid(String name, PageFilter filter) {
		Grid grid = new Grid();
		List<Sku> list = new ArrayList<Sku>();
		long count = 0;
		Map<String ,Object> map=new HashMap<String,Object>();
		try {
			map.put("name", name);
			list= skuBiz.searchReleasePage(map, filter.getStartIndex(),filter.getRows());
			count = skuBiz.searchPageCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}
	
	
	/**
	 * 上架
	 * @param skuId
	 * @return
	 */
	@RequestMapping("/grounding")
	@ResponseBody
	public Json grounding(String skuId,String status){
		Json json = new Json();
		
		if(StringUtils.isBlank(skuId) || StringUtils.isBlank(status)){
			json.setSuccess(false);
			json.setMsg("参数错误");
			return json ;
		}
		
		
		try{
			
			/**
			 * 上架状态为：1 下架状态为 0
			 */
			int update = skuBiz.updateStatus(skuId, Integer.parseInt(status));
			if(update == 1 ){
				json.setSuccess(true);
			}else{
				json.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
		}
		
		return json;
	}

	@RequestMapping("/audit")
	@ResponseBody
	public Json audit(String skuId,String status){
		Json json = new Json();
		
		if(StringUtils.isBlank(skuId) || StringUtils.isBlank(status)){
			json.setSuccess(false);
			json.setMsg("参数错误");
			return json ;
		}
		
		
		try{
			
			/**
			 * 审核通过状态为：1 审核不通过状态为 2.默认为未审核0
			 */
			int update = skuBiz.audit(skuId, Integer.parseInt(status));
			if(update == 1 ){
				json.setSuccess(true);
			}else{
				json.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
		}
		
		return json;
	}
	
	/* 跳转到审核页面 */
	@RequestMapping("/auditPage")
	public String auditPage(HttpServletRequest request,Integer skuId){
		Sku auditSku = new Sku();
		try{
			if(skuId!=null)
			{
				auditSku = skuBiz.searchSkuById(skuId);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("auditSku", auditSku);
		return "goods/skuAudit";
	}
	
	@RequestMapping("/disPassAudit")
	@ResponseBody
	public ModelAndView disPassAudit(String skuId,String status,String reason){
		Json json = new Json();
		
		if(StringUtils.isBlank(skuId) || StringUtils.isBlank(status)){
			json.setSuccess(false);
			json.setMsg("参数错误");
			return null ;
		}
		
		
		try{
			
			/**
			 * 审核通过状态为：1 审核不通过状态为 2.默认为未审核0
			 */
			int update = skuBiz.disPassAudit(skuId, status,reason);
			if(update == 1 ){
				json.setSuccess(true);
			}else{
				json.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
		}
		return new ModelAndView("redirect:/sku/auditList");
		
	}
	/*@RequestMapping("/disPassAudit")
	@ResponseBody
	public Json disPassAudit(String skuId,String status,String reason){
		Json json = new Json();
		
		if(StringUtils.isBlank(skuId) || StringUtils.isBlank(status)){
			json.setSuccess(false);
			json.setMsg("参数错误");
			return json ;
		}
		
		
		try{
			
			*//**
			 * 审核通过状态为：1 审核不通过状态为 2.默认为未审核0
			 *//*
			int update = skuBiz.disPassAudit(skuId, status,reason);
			if(update == 1 ){
				json.setSuccess(true);
			}else{
				json.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
		}
		
		return json;
	}*/
}


