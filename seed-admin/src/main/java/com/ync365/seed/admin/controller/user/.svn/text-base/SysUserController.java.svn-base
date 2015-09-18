package com.ync365.seed.admin.controller.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ync365.seed.admin.vo.base.Grid;
import com.ync365.seed.admin.vo.base.PageFilter;
import com.ync365.seed.bussiness.modules.user.biz.SysUserBiz;
import com.ync365.seed.bussiness.modules.user.entity.SysUser;
import com.ync365.seed.bussiness.modules.user.entity.SysUserInfo;

@Controller
@RequestMapping("/user")
public class SysUserController {


	@Autowired
	private SysUserBiz sysUserBiz;
	
	
	/**列表页
	 * @author xieang
	 * 2015年9月15日
	 * @return
	 */
	@RequestMapping("/list")
	public String list() {
		return "user/sysUserList";
	}

	/**获取grid列表
	 * @author xieang
	 * 2015年9月15日
	 * @param name
	 * @param filter
	 * @return
	 */
	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String name, PageFilter filter) {
		Grid grid = new Grid();
		List<SysUser> list = new ArrayList<SysUser>();
		long count = 0;
		Map<String ,Object> map=new HashMap<String,Object>();
		SysUser sysUser = new SysUser();
		try {
			map.put("name", name);
			list=null; //sysUserBiz.selectSysUserByPage(sysUser, filter.getStartIndex(),filter.getRows());
			count = sysUserBiz.selectSysUserByPageCount(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}
	
	/**用户添加页
	 * @author xieang
	 * 2015年9月15日
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(){
		return "user/sysUserAdd";
	}
	
	/**
	 * 用户编辑页
	 * @author xieang
	 * 2015年9月14日
	 * @param model
	 * @param userNum
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(Model model, String userNum){
		SysUser sysUser = sysUserBiz.selectSysUserByUserNum(userNum);
		/*if(sysUser.getSysUserInfo()==null){
			sysUser.setSysUserInfo(new SysUserInfo());
		}*/
		model.addAttribute("sysUser", sysUser);
		return "user/sysUserEdit";
	}
	/**
	 * 用户详情页
	 * @author xieang
	 * 2015年9月14日
	 * @param model
	 * @param userNum
	 * @return
	 */
	@RequestMapping("/infoPage")
	public String infoPage(Model model, String userNum){
		SysUser sysUser = sysUserBiz.selectSysUserByUserNum(userNum);
		/*if(sysUser.getSysUserInfo()==null){
			sysUser.setSysUserInfo(new SysUserInfo());
		}*/
		model.addAttribute("sysUser", sysUser);
		return "user/sysUserInfo";
	}
	
	/**编辑保存操作
	 * @author xieang
	 * 2015年9月15日
	 * @param sysUser
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(SysUser sysUser){
		if(sysUser.getUserNum()!=null){
			//sysUserBiz.updateSysUserAndInfoByUserNum(sysUser);
		}
		return "redirect:list";
	}
	
	/**时间自动格式化
	 * @author xieang
	 * 2015年9月15日
	 * @param bin
	 */
	@InitBinder
    public void InitBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor( new SimpleDateFormat("yyyy-MM-dd"), true));

    }
}
