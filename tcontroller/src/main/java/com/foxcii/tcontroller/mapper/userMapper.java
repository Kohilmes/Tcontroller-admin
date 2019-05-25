package com.foxcii.tcontroller.mapper;

import com.foxcii.tcontroller.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(user record);

    int registerOnlyAccount(user record);

    int registerOnlyWxid(user record);

    int insertSelective(user record);

    user selectByPhone(String userPhone);

    user selectByPrimaryKey(Integer userid);

    user selectByWxid(String wxid);

    user selectOnlyBtAccount(String userName);

    user selectByAccount(user record);

    int updateWxid(user record);

    int updatePhoneNum(user record);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}