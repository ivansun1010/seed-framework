package com.ync365.seed.admin.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.bussiness.modules.goods.biz.GoodsQueryBiz;
import com.ync365.seed.commons.solr.GoodsQueryBean;
import com.ync365.seed.web.vo.Grid;

@Controller
@RequestMapping("/goodsQuery")
public class GoodsQueryController {

	@Autowired
	GoodsQueryBiz goodsQueryBiz ;
	
	@RequestMapping("/list")
	public String list(){
		
		return "goods/goodsQueryList";
	}
	
	@RequestMapping("/grid")
	@ResponseBody
	public Grid  dataGrid(GoodsQueryBean bean,String content,PageFilter filter){
		Grid grid = goodsQueryBiz.searchPage(bean,content, filter.getRows(), filter.getStartIndex()) ;
		return grid;
	}
}
