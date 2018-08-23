package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleInfoController{

    @Autowired
    private RoleInfoService roleInfoService;
    @RequestMapping(value = "login.do")
    public String getLogin(String userName,String password,Integer roletypeid) throws  Exception{
        RoleInfo roleInfo=roleInfoService.getRoleInfoLogin(userName,password);
        if (roleInfo==null){
            return JSON.toJSONString("用户名和密码错误");
        }else {
            if (roleInfo.getRoleTypeId()==roletypeid){
                return JSON.toJSONString(roleInfo.getRoleTypeId());
            }else {
                return JSON.toJSONString("科室类型编号错误");
            }
        }
    }
}
