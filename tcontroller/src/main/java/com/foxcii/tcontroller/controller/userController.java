package com.foxcii.tcontroller.controller;

import com.alibaba.fastjson.JSONObject;
import com.foxcii.tcontroller.common.GlobalResult;
import com.foxcii.tcontroller.common.WechatUtil;
import com.foxcii.tcontroller.entity.user;
import com.foxcii.tcontroller.mapper.userMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user",method = RequestMethod.GET)
    public class userController {

    @Resource
    private userMapper userMapper;

    @RequestMapping("/isAccount")
    public user isAccount(@RequestParam("userName")String userName){
        user user=this.userMapper.selectOnlyBtAccount(userName);
        if (user!=null){
            user islive=new user();
            islive.setUserid(user.getUserid());
            islive.setUserName(user.getUserName());
            islive.setUserPhone(user.getUserPhone());
            return islive;
        }else {
            return user;
        }
    }
    @RequestMapping("/updatePwd")
    public int updatePwd(@RequestParam("userName")String adminName,
                      @RequestParam("userPwd")String adminPwd){

        user user=new user(adminName,adminPwd);
        return userMapper.updatePwd(user);
    }

    @RequestMapping("/updateAddress")
    public int updateAddress(@RequestParam("userid")Integer userid,
                         @RequestParam("userAddress")String userAddress){

        user user=new user();
        user.setUserid(userid);
        user.setUserAddress(userAddress);
        return userMapper.updateAddress(user);
    }

    @RequestMapping("/login")
    public user login(@RequestParam("userName")String adminName,
                      @RequestParam("userPwd")String adminPwd){

        user user=new user(adminName,adminPwd);
        user userlog=userMapper.selectByAccount(user);
        if (userlog!=null){
            if (userlog.getWxId()!=null)userlog.setWxId("???");
            userlog.setUserPwd("???");
        }
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


    @RequestMapping("/registerByUserid")
    public user registerByUseid(@RequestParam("userid")Integer userid,
                                @RequestParam("userName")String adminName,
                                @RequestParam("userPwd")String adminPwd){

        user isReg=userMapper.selectOnlyBtAccount(adminName);
        if (isReg!=null)return new user(-1);
        user user=new user(userid,adminName,adminPwd);
        if (userMapper.updateByPrimaryKey(user)==1){
            return userMapper.selectOnlyBtAccount(adminName);
        }else {
            return new user();
        }
    }

    @RequestMapping("/wx/bind")
    public GlobalResult user_login(@RequestParam("userid")int userid,
                                   @RequestParam("code")String code){
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");


        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        user user = this.userMapper.selectByPrimaryKey(userid);

        String skey = UUID.randomUUID().toString();
        GlobalResult result;
        if (user.getWxId()==null){
            user wxuser=this.userMapper.selectByWxid(openid);
            // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
            if (wxuser==null){

                user.setWxId(openid);
                this.userMapper.updateWxid(user);
                user.setWxId("???");
                result = GlobalResult.build(100, "wxid update", user);
            }else {
                result = GlobalResult.build(200, "wxid is reg", skey);
            }

        }else {
            result = GlobalResult.build(300, "userid is binded wxid", skey);
        }
        return result;
    }

    @RequestMapping("/bindPhoneNum")
    public user bindPhoneNum(@RequestParam("userid")int userid,
                             @RequestParam("userPhone")String userPhone){

        user user=this.userMapper.selectByPhone(userPhone);
        if (user!=null){
            user=new user(-1);
            return user;
        }else {
            user=new user();
            user.setUserid(userid);
            user.setUserPhone(userPhone);
            if (this.userMapper.updatePhoneNum(user)==1){
                user=this.userMapper.selectByPhone(userPhone);
                user.setUserPwd("???");
                if (user.getWxId()!=null){
                    user.setWxId("???");
                }
                return user;
            }
            else {
                user.setUserid(null);
                return user;
            }
        }
    }

    @RequestMapping("/wx/login")
    public GlobalResult user_login(@RequestParam("code")String code){
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        user user = this.userMapper.selectByWxid(openid);

        String skey = UUID.randomUUID().toString();
        GlobalResult result;
        if (user==null){
            user=new user();
            user.setWxId(openid);
            if (userMapper.registerOnlyWxid(user)==1){
                user = this.userMapper.selectByWxid(openid);
                return GlobalResult.build(50, "wxid first login", user);
            }else {
                return GlobalResult.build(49, "server error", skey);
            }

        }else {
            user wxuser=this.userMapper.selectByWxid(openid);
            wxuser.setUserPwd("???");
            wxuser.setWxId("???");
            result = GlobalResult.build(100, "login", wxuser);
        }
        return result;
    }

    @RequestMapping("/selectAll")
    public List<user> user_selectAll(){
        List<user> users=this.userMapper.selectAll();
        return  users;
    }

    @RequestMapping("/selectByuserId")
    public user selectByPrimaryKey(@RequestParam("userid")int userid){

        user user=this.userMapper.selectByPrimaryKey(userid);

        return user;
    }

    @RequestMapping("/deleteByPrimaryKey")
    public user deleteByPrimaryKey(@RequestParam("userid")int userid){

        this.userMapper.deleteByPrimaryKey(userid);

        return null;
    }
}
