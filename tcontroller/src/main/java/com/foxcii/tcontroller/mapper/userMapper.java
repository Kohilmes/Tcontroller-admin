package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer userid);

    user selectByAccount(user record);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}