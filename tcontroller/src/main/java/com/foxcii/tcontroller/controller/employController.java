package com.foxcii.tcontroller.controller;


import com.foxcii.tcontroller.entity.employ;
import com.foxcii.tcontroller.mapper.employMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/employ",method = RequestMethod.GET)
public class employController {


    @Resource
    private employMapper employMapper;

    @RequestMapping("/selectByUserid")
    public List<employ> selectByUserid(@RequestParam("userid")int userid){
        List<employ> employs=employMapper.selectByUserid(userid);
        return employs;
    }

    @RequestMapping("/selectByEmployid")
    public employ selectByEmployid(@RequestParam("employid")int employid){
        employ employ=employMapper.selectByPrimaryKey(employid);
        return employ;
    }

    @RequestMapping("/addEmploy")
    public int addEmploy(@RequestParam("employInfo")String employinfo,
                         @RequestParam("employTime")String employTime,
                         @RequestParam("employAddress")String employAddress,
                         @RequestParam("userid")int userid){

        employ employ=new employ(employinfo,employTime,employAddress,userid);
        return  this.employMapper.insertEmploy(employ);
    }
}
