package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.admin;

public interface adminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(admin record);

    int insertSelective(admin record);

    admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(admin record);

    int updateByPrimaryKey(admin record);
}