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

    @RequestMapping("/updatestafix")
    public int updatestafix(@RequestParam("employid")int employid,
                            @RequestParam("employStatus")String status,
                            @RequestParam("fixid")int fixid){

        employ employ=new employ(employid,status,fixid);
//        employ employ=this.employMapper.selectByPrimaryKey(employid);
        return this.employMapper.updatestafix(employ);
    }

    @RequestMapping("/updatesta")
    public int updatesta(@RequestParam("employid")int employid,
                         @RequestParam("employStatus")String status){

        employ employ=new employ(employid,status);
//        employ employ=this.employMapper.selectByPrimaryKey(employid);
        return this.employMapper.updatesta(employ);
    }
}
