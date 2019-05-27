package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.know;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface knowMapper {
    int deleteByPrimaryKey(Integer knowid);

    int insert(know record);

    int insertSelective(know record);

    know selectByPrimaryKey(Integer knowid);

    List<know> selectAll();

    int updateByPrimaryKeySelective(know record);

    int updateByPrimaryKey(know record);

    int seeKnow(Integer knowid);
}