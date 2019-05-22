package com.foxcii.tcontroller.controller;

import com.foxcii.tcontroller.entity.user;
import com.foxcii.tcontroller.mapper.userMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user",method = RequestMethod.GET)
public class userController {

    @Resource
    private userMapper userMapper;

    @RequestMapping("/login")
    public user login(@RequestParam("userName")String adminName,
                      @RequestParam("userPwd")String adminPwd){

        user user=new user(adminName,adminPwd);
        user userlog=userMapper.selectByAccount(user);
        return userlog;
    }
    @RequestMapping("/register")
    public user register(@RequestParam("userName")String adminName,
                         @RequestParam("userPwd")String adminPwd){

        user isReg=userMapper.selectOnlyBtAccount(adminName);
        if (isReg!=null)return new user(-1);
        user user=new user(adminName,adminPwd);
        if (userMapper.registerOnlyAccount(user)==1){
            return userMapper.selectOnlyBtAccount(adminName);
        }else {
            return new user();
        }
    }
}
