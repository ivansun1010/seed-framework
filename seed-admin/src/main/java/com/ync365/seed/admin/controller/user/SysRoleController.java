package com.ync365.seed.admin.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ync365.seed.bussiness.modules.user.biz.SysModuleBiz;
import com.ync365.seed.bussiness.modules.user.biz.SysRoleBiz;
import com.ync365.seed.bussiness.modules.user.biz.SysRoleModuleBiz;
import com.ync365.seed.bussiness.modules.user.entity.SysModule;
import com.ync365.seed.bussiness.modules.user.entity.SysRole;
import com.ync365.seed.bussiness.modules.user.entity.SysRoleModule;
import com.ync365.seed.web.vo.ZTreeVo;


/**
 * 角色controller
 *
 */
@Controller
@RequestMapping("/sysrole")
public class SysRoleController {

	@Autowired
	private SysModuleBiz sysModuleBiz;
	@Autowired
	private SysRoleModuleBiz sysRoleModuleBiz;
	@Autowired
	private SysRoleBiz sysRoleBiz;
	
	/**
	 * list请求
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return "user/sysRoleList";
	}
	
	@RequestMapping("/grid")
	@ResponseBody
	public Grid dataGrid(String name, PageFilter filter) {
		Grid grid = new Grid();
		List<SysRole> list = new ArrayList<SysRole>();
		long count = 0;
		Map<String ,Object> map=new HashMap<String,Object>();
		try {
			map.put("name", name);
			list=null ;//sysRoleBiz.searchPage(map, filter.getStartIndex(),filter.getRows());
			count = 0 ;//sysRoleBiz.searchPageCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.setRows(list);
		grid.setRecords(count);
		grid.setPageSize(filter.getRows());
		return grid;
	}
	
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "user/sysRoleAdd";
	}
	
	/**
	 * 新增保存
	 * @param sysRole
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView add(SysRole sysRole){
		int temp = 0;
		try {
			temp = sysRoleBiz.insert(sysRole);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/sysrole/list");
	}
	
	/**
	 * 编辑
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(@RequestParam("id") int id,
			HttpServletRequest request) {
		SysRole sysRole;
		try {
			sysRole = sysRoleBiz.selectByPrimaryKey(id);
			request.setAttribute("sysRole", sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/sysRoleEdit";
	}
	
	/**
	 * 编辑保存
	 * @param sysRole
	 * @return
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(SysRole sysRole){
		int temp = 0;
		try {
			temp = sysRoleBiz.updateByPrimaryKey(sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/sysrole/list");
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		int temp = 0;
		boolean flag = false;
		try {
			temp = 0;//sysRoleBiz.deleteByPrimaryKey(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/sysrole/list");
	}
	
	/**
	 * 编辑权利
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/editRoleModule")
	public String editRoleModule(@RequestParam("id") int id,HttpServletRequest request) {
		request.setAttribute("id", id);
		return "/user/sysRoleModule";
	}
	
	/**
	 * 获取权限tree
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/getRoleModuleTree")
	@ResponseBody
	public List<ZTreeVo> getRoleModuleTree(HttpServletRequest request,Integer id) {
		List<ZTreeVo> list = new ArrayList<ZTreeVo>();
		try {
			//查询所有的权限list 封装成tree
			List<SysModule> categoryList = null;//sysModuleBiz.selectSysModuleAll();
			for (SysModule c : categoryList) {
				ZTreeVo vo = new ZTreeVo();
				vo.setId(String.valueOf(c.getId()));
				vo.setName(c.getModuleName());
				vo.setpId(String.valueOf(c.getParentId()));
				list.add(vo);

			}

			//通过角色id SysRoleModule表中查询已经存在的权限
			List<SysRoleModule> bcList = null;//sysRoleModuleBiz.searchRoleModuleList(id);
			if (bcList != null && bcList.size() > 0) {
				for ( SysRoleModule bc : bcList) {
					for (ZTreeVo t : list) {
						if (String.valueOf(bc.getModuleId()).equals(t.getId())) {
							//System.out.println("------------------"+ t.getId().equals(bc.getModuleId()));
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
	
	/**
	 * 编辑添加角色权限对应关系
	 * @param id
	 * @param tempId
	 * @return
	 */
	@RequestMapping(value = "/addRoleModule")
	@ResponseBody
	public ModelAndView addRoleModule(int id, String tempId) {

		int num = 0;
		try {
			if (StringUtils.isNotBlank(tempId)) {
				num = 0; //sysRoleModuleBiz.addRoleModules(id, tempId);
			} else {
				num = 0;//sysRoleModuleBiz.deleteByRoleId(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/sysrole/list");
	}
}
