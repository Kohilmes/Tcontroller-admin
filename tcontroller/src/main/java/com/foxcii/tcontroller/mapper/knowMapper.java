package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.know;

public interface knowMapper {
    int deleteByPrimaryKey(Integer knowid);

    int insert(know record);

    int insertSelective(know record);

    know selectByPrimaryKey(Integer knowid);

    int updateByPrimaryKeySelective(know record);

    int updateByPrimaryKey(know record);
}