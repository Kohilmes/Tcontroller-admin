package com.foxcii.tcontroller.controller;


import com.foxcii.tcontroller.entity.admin;
import com.foxcii.tcontroller.mapper.adminMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/admin",method = RequestMethod.POST)
public class adminController {

    @Resource
    private adminMapper adminMapper;

    @RequestMapping("/login")
    public admin login(@RequestParam("adminName")String adminName,
                       @RequestParam("adminPwd")String adminPwd){


        return
    }
}
