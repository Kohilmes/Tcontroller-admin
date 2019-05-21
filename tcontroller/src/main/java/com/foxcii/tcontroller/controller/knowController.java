package com.foxcii.tcontroller.controller;

import com.foxcii.tcontroller.entity.know;
import com.foxcii.tcontroller.mapper.knowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/know",method = RequestMethod.GET)
public class knowController {

    @Resource
    private knowMapper knowMapper;

    @RequestMapping("/selectAll")
    public List<know> selectAll(){
        List<know> knows=knowMapper.selectAll();
        return knows;
    }

}
