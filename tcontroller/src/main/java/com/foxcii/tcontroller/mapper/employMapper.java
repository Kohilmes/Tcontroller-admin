package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.employ;

public interface employMapper {
    int deleteByPrimaryKey(Integer employid);

    int insert(employ record);

    int insertSelective(employ record);

    employ selectByPrimaryKey(Integer employid);

    int updateByPrimaryKeySelective(employ record);

    int updateByPrimaryKey(employ record);
}