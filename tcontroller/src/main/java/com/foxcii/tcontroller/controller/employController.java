package com.foxcii.tcontroller.controller;

import com.foxcii.tcontroller.entity.employ;
import com.foxcii.tcontroller.entity.fix;
import com.foxcii.tcontroller.entity.user;
import com.foxcii.tcontroller.mapper.employMapper;
import com.foxcii.tcontroller.mapper.fixMapper;
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



    @RequestMapping("/selectAllemploy")
    public List<employ> employ_selectAll(){
            List<employ> employs=this.employMapper.selectAllemploy();
            return  employs;
    }

    @RequestMapping("/selectByemployId")
    public employ selectByPrimaryKey(@RequestParam("employid")int employid){

        employ employ=this.employMapper.selectByPrimaryKey(employid);

        return employ;
    }

    @RequestMapping("/deleteByPrimaryKey")
    public employ deleteByPrimaryKey(@RequestParam("employid")int employid){

        this.employMapper.deleteByPrimaryKey(employid);

        return null;
    }
}
