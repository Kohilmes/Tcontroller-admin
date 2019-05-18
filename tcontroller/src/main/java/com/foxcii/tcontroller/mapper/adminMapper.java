package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface adminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(admin record);

    int insertSelective(admin record);

    admin selectByPrimaryKey(Integer adminid);

    admin selectByaccount(admin record);

    int updateByPrimaryKeySelective(admin record);

    int updateByPrimaryKey(admin record);
}