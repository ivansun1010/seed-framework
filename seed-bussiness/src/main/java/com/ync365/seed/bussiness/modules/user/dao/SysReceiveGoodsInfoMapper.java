package com.ync365.seed.bussiness.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.ync365.seed.bussiness.modules.user.entity.SysReceiveGoodsInfo;
import com.ync365.seed.commons.annotation.MyBatisRepository;

@MyBatisRepository
public interface SysReceiveGoodsInfoMapper {

	/**
	 * 添加信息
	 * 
	 * @param record
	 * @return
	 */
    int insertSelective(SysReceiveGoodsInfo record);
    
    /**
     * 编号 userNum 获取信息
     * 
     * @param userNum
     * @return
     */
    SysReceiveGoodsInfo selectByPrimaryKey(String userNum);
    
    /**
     * 编号 userNum 更新信息
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysReceiveGoodsInfo record);
    
    /**
     * 通过 userNum 删除数据
     * 
     * @param userNum
     * @return
     */
    int deleteByPrimaryKey(String userNum);
    
    /**
	 * 多功能查询，
	 * 
	 * @param map
	 * @return
	 */
	List<SysReceiveGoodsInfo> selectPageByMap(Map<String, Object> map);

	/**
	 * 条件获取数量
	 * 
	 * @param map
	 * @return
	 */
	int selectPageCount(Map<String, Object> map);
}