package com.ync365.seed.bussiness.modules.user.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysReceiveGoodsInfoMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysReceiveGoodsInfo;



@Service
public class SysReceiveGoodsInfoBiz {
	@Autowired
	SysReceiveGoodsInfoMapper sysReceiveGoodsInfoMapper;
	
	/**
	 *编号 userNum 获取信息 
	 * 
	 * @param userNum
	 * @return
	 */
	public SysReceiveGoodsInfo selectByPrimaryKey(String  userNum) {
		return sysReceiveGoodsInfoMapper.selectByPrimaryKey(userNum);
	}
	
	/**
	 * 编号 userNum 删除信息，物理删除
	 * 
	 * @param popStoreNum
	 * @return
	 */
	public int deleteByPrimaryKey(String  userNum){
		return sysReceiveGoodsInfoMapper.deleteByPrimaryKey(userNum);
	}
	
	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
	public int insert(SysReceiveGoodsInfo record){
		return sysReceiveGoodsInfoMapper.insertSelective(record);
	}
	
	/**
	 * 通过 userNum 编号修改信息
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysReceiveGoodsInfo record){
		return sysReceiveGoodsInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 多功能查询 所有List<SysReceiveGoodsInfo>
	 * 
	 * @param map
	 * @return
	 */
	public List<SysReceiveGoodsInfo> selectPageByMap(Map<String, Object> map){
		return sysReceiveGoodsInfoMapper.selectPageByMap(map);
	}
	
	/**
	 * 条件获取数量
	 * 
	 * @param map
	 * @return
	 */
	public int selectPageCount(Map<String, Object> map){
		return sysReceiveGoodsInfoMapper.selectPageCount(map);
	}
}
