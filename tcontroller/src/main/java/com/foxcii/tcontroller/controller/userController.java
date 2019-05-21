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
    public user login(@RequestParam("adminName")String adminName,
                      @RequestParam("adminPwd")String adminPwd){

        user user=new user(adminName,adminPwd);
        user userlog=userMapper.selectByAccount(user);
        return userlog;
    }
}
