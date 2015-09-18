package com.ync365.seed.bussiness.modules.user.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysPopStoreMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysPopStore;


@Service
public class SysPopStoreBiz {
	@Autowired
	SysPopStoreMapper sysPopStoreMapper;
	
	/**
	 *编号 popStoreNum 获取信息 
	 * 
	 * @param popStoreNum
	 * @return
	 */
	public SysPopStore selectByPrimaryKey(String  popStoreNum) {
		return sysPopStoreMapper.selectByPrimaryKey(popStoreNum);
	}
	
	/**
	 * 编号 popStoreNum 删除信息，物理删除
	 * 
	 * @param popStoreNum
	 * @return
	 */
	public int deleteByPrimaryKey(String  popStoreNum){
		return sysPopStoreMapper.deleteByPrimaryKey(popStoreNum);
	}
	
	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	public int insert(SysPopStore record){
		return sysPopStoreMapper.insertSelective(record);
	}
	
	/**
	 * 通过 popStoreNum 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysPopStore record){
		return sysPopStoreMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 多功能查询 所有List<SysPopStoreMapper> 分页添加pageIndex,pageSize参数
	 * 
	 * @param map
	 * @return
	 */
	public List<SysPopStore> selectPageByMap(Map<String, Object> map){
		return sysPopStoreMapper.selectPageByMap(map);
	}
	
	/**
	 * 条件获取数量
	 * 
	 * @param map
	 * @return
	 */
	public int selectPageCount(Map<String, Object> map){
		return sysPopStoreMapper.selectPageCount(map);
	}
}
