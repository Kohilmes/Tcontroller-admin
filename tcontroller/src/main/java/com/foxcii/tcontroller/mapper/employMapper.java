package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.employ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface employMapper {
    int deleteByPrimaryKey(Integer employid);

    int insert(employ record);

    int insertSelective(employ record);

    int insertEmploy(employ record);

    employ selectByPrimaryKey(Integer employid);

    List<employ> selectByUserid(Integer userid);

    int updateByPrimaryKeySelective(employ record);

    int updateByPrimaryKey(employ record);
}