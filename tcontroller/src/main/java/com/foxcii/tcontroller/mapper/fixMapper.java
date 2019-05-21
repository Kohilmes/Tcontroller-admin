package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.fix;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface fixMapper {
    int deleteByPrimaryKey(Integer fixid);

    int insert(fix record);

    int insertSelective(fix record);

    fix selectByPrimaryKey(Integer fixid);

    int updateByPrimaryKeySelective(fix record);

    int updateByPrimaryKey(fix record);
}