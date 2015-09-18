package com.ync365.seed.bussiness.modules.user.biz;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysAdminMapper;
import com.ync365.seed.bussiness.modules.user.dao.SysModuleMapper;
import com.ync365.seed.bussiness.modules.user.dao.SysRoleMapper;
import com.ync365.seed.bussiness.modules.user.dao.SysUserRoleMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysAdmin;
import com.ync365.seed.bussiness.modules.user.util.NumGenerator;

@Service
public class SysAdminBiz {
	
	@Autowired
	private SysAdminMapper sysAdminMapper;
	
	
	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Autowired
	SysModuleMapper  sysModuleMapper;
	
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
    /**
     * 功能描述：添加用户
     * @param record
     * @return
     */
    public int insert(SysAdmin record) {
    	//自动生成admin_num编号
    	record.setAdminNum(NumGenerator.getUserNum());
    	return sysAdminMapper.insertSelective(record);
    }

    
    /**
     * 功能描述：查询用户by id
     * @param id
     * @return
     */
   /* public SysAdmin selectByNum(String adminNum) {
    	return sysAdminMapper.selectByNum(adminNum);
    }*/

    /**
     * 通过adminLoginName查询用户 信息及 用户权限 和角色 
     * @param adminLoginName
     * @return
     */
    public SysAdmin selectByAdminLoginName(String adminLoginName){
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("adminLoginName", adminLoginName);
    	map.put("pageIndex", 0);
    	map.put("pageSize", 10);
    	//查询用户信息 sysadmin
    	List<SysAdmin> sysAdmin = sysAdminMapper.selectPageByMap(map);
//    	if(null != sysAdmin){
//    		//关联查询用户角色
//    		List<SysRole> list = sysRoleMapper.selectSysRoleByAdminNum(sysAdmin.getAdminNum());
//    		if(null != list && list.size()>0){
//    			for (SysRole te : list){
//    				//查询用户权限
//    				List<SysModule> moduleList = sysModuleMapper.selectByRoleAndModuel(te.getId());
//    				if(null != moduleList && moduleList.size() > 0){
//    					te.setSysModules(moduleList);
//    				}
//    			}
//    			sysAdmin.setSysroles(list);
//    		}
//    	}
    	return sysAdmin.get(0);
    }
    
    /**
     * 功能描述：更新用户
     * @param record
     * @return
     */
   /* public int updateByNum(SysAdmin record) {
    	return sysAdminMapper.updateByNum(record);
    }*/
    
    
    /**
     * 功能描述：查询所有用户。
     * @param map 查询条件
     * @param pageIndex
     * @param pageSize
     * @return
     */
    /*public List<SysAdmin> searchPage(Map<String, Object> parameters,int pageIndex,int pageSize) {
    	parameters.put("pageIndex", pageIndex);
    	parameters.put("pageSize", pageSize);
		return sysAdminMapper.searchPage(parameters);
    }*/
    
    
    /**
     * 功能描述：通过roleId 或 roleName 查询所有用户
     * @param parameters
     * @param pageIndex
     * @param pageSize
     * @return
     */
   /* public List<SysAdmin> searchPageByRole(Map<String, Object> parameters,int pageIndex,int pageSize) {
    	parameters.put("pageIndex", pageIndex);
    	parameters.put("pageSize", pageSize);
    	return sysAdminMapper.searchPageByRole(parameters);
    }*/
    
    
    /**
     * 功能描述：添加用户服务区。
     * @param adminNum 用户编号
     * @param serviceDistinct 服务区
     * @return
     */
   /* public int insertService(String adminNum, String serviceDistinct) {
    	Map<String, Object> services = new HashMap<String, Object>();
    	
    	if (StringUtils.isNotBlank(adminNum) && StringUtils.isNotBlank(serviceDistinct)) {
    		services.put("adminNum", adminNum);
    		services.put("serviceDistinct", serviceDistinct);
    		return sysAdminMapper.insertService(services);
    	} else {
    		throw new NullPointerException();
    	}
    }*/
    
    
    /**
     * 功能描述：查询用户所属的服务区 by adminNum
     * @param adminNum
     * @return
     */
    /*public SysAdminService selectServiceByNum(String adminNum) {
		return sysAdminMapper.selectServiceByNum(adminNum);
    }*/
    
    
    /**
     * 功能描述：将用户绑定分配至父类用户下
     * 如，将SE用户分配到A+用户下。
     * @param adminNum 用户id
     * @param supAdminNum 父类
     * @return
     */
    /*public int insertRelationship(String adminNum, String supAdminNum) {
    	Map<String, Object> relationships = new HashMap<String, Object>();
    	relationships.put("adminNum", adminNum);
    	relationships.put("supAdminNum", supAdminNum);
    	return sysAdminMapper.insertRelationship(relationships);
    }*/
    
    
    
    /**
     * 功能描述：查看用户绑定的关系
     * @param supAdminNum
     * @return
     */
    /*public List<SysAdmin> selectRelationship(String supAdminNum) {
    	return sysAdminMapper.selectRelationship(supAdminNum);
    }*/
    

    /**
     * 功能描述：根据用户admin_num字段删除用户。
     * @param adminNum
     * @return
     */
    /*public int deleteByNum(String adminNum) {
    	return sysAdminMapper.deleteByNum(adminNum);
    }*/
    
}