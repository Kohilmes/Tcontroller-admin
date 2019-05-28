package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.fix;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface fixMapper {
    int deleteByPrimaryKey(Integer fixid);

    List<fix>selectAllfix();

    int insert(fix record);

    int insertSelective(fix record);

    fix selectByPrimaryKey(Integer fixid);

    int updateByPrimaryKeySelective(fix record);

    int updateByPrimaryKey(fix record);
}