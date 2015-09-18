package com.ync365.seed.bussiness.modules.goods.dao;

import java.util.List;

import com.ync365.seed.bussiness.modules.goods.entity.PicInfo;
import com.ync365.seed.commons.annotation.MyBatisRepository;
@MyBatisRepository
public interface PicInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PicInfo record);

    int insertSelective(PicInfo record);

    PicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PicInfo record);

    int updateByPrimaryKey(PicInfo record);
    List<PicInfo> selectByPicInfo(PicInfo picInfo);
}