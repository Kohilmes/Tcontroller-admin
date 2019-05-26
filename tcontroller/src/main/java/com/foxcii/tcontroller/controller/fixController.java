package com.foxcii.tcontroller.controller;

import com.foxcii.tcontroller.entity.fix;
import com.foxcii.tcontroller.mapper.fixMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/fix",method = RequestMethod.GET)
public class fixController {

    @Resource
    private fixMapper fixMapper;

    @RequestMapping("/selectByFixid")
    public fix selectByFixid(@RequestParam("fixid")Integer fixid){
        fix fix=fixMapper.selectByPrimaryKey(fixid);
        return fix;
    }
}
