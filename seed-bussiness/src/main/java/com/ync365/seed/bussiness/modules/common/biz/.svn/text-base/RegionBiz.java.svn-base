package com.ync365.seed.bussiness.modules.common.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.common.dao.RegionDao;
import com.ync365.seed.bussiness.modules.common.entity.Region;

@Service
public class RegionBiz {

	@Autowired
	RegionDao regionDao ;
	
	public Region selectByPrimaryKey(Integer id) {
		return regionDao.selectByPrimaryKey(id);
	}
	
	/**
	 * 查询分页
	 * @param qChName
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Region> searchPage(String qName,int startIndex,int pageSize){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", qName);
		map.put("pageIndex", startIndex);
		map.put("pageSize", pageSize);
		return regionDao.searchPage(map);
	}
	
	public int searchPageCount(String name) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", name);
		return regionDao.searchPageCount(map);
	}
	
	/**
	 * 查询地区的一二级
	 * @return
	 */
	public List<Region> selectByLevel() {
		List<Integer> levelList = new ArrayList<Integer>();
		levelList.add(1);
		levelList.add(2);
		
		return regionDao.selectListByLevel(levelList);
	}

	public int add(Region region) {
		return regionDao.insert(region);
	}

	public int edit(Region region) {
		return regionDao.updateByPrimaryKeySelective(region);
	}

	public Region selectById(Integer id) {
		return regionDao.selectByPrimaryKey(id);
	}
	/**
	 * 获取区域及其父区域
	 * @param id
	 * @return 按顺序的区域数组，区域，父区域，父区域的父区域。。。最多5级
	 */
	public Region[] selectRegionAndParentRegionById(Integer id){
		Region region=regionDao.selectByPrimaryKey(id);
		List<Region> list=new ArrayList<Region>();
		int pid=region.getPid();
		list.add(region);
		while(pid!=0){
			Region region_temp=regionDao.selectByPrimaryKey(pid);
			list.add(region_temp);
			pid=region_temp.getPid();
		}
		Region[] regions=new Region[list.size()];
		return list.toArray(regions);
	}
}
