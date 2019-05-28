package com.foxcii.tcontroller.controller;

import com.foxcii.tcontroller.entity.fix;
import com.foxcii.tcontroller.mapper.fixMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/fixer",method = RequestMethod.GET)
public class fixController {

    @Resource
    private fixMapper fixMapper;

    @RequestMapping("/selectByfixid")
    public fix selectByFixid(@RequestParam("fixid")Integer fixid){
        fix fix=fixMapper.selectByPrimaryKey(fixid);
        return fix;
    }


    @RequestMapping("/selectAllfix")
    public List<fix> fix_selectAll(){
            List<fix> fixs=this.fixMapper.selectAllfix();
            return  fixs;
    }

    @RequestMapping("/selectByfixId")
    public fix selectByPrimaryKey(@RequestParam("fixid")int fixid){

        fix fix=this.fixMapper.selectByPrimaryKey(fixid);

        return fix;
    }

    @RequestMapping("/deleteByPrimaryKey")
    public user deleteByPrimaryKey(@RequestParam("fixid")int fixid){

        this.fixMapper.deleteByPrimaryKey(fixid);

        return null;
    }
}
