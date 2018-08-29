package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class RoleInfoController{

    @Autowired
    private RoleInfoService roleInfoService;

    /**
     * 用户选择登录
     * @param userName
     * @param password
     * @param roletypeid
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login.do")
    public String getLogin(String userName, String password, Integer roletypeid, HttpServletRequest request) throws  Exception{
        RoleInfo roleInfo=roleInfoService.getRoleInfoLogin(userName,password);
        Integer sectionId=roleInfoService.getSectionIdByRoleInfoId(roleInfo.getRoleInfoId());
        System.out.println(roleInfo.getRoleInfoId());
        if (roleInfo==null){
            return JSON.toJSONString("用户名和密码错误");
        }else {
            if (roleInfo.getRoleTypeId()==roletypeid){
                HttpSession session=request.getSession();
                session.setAttribute("roleInfo",roleInfo);
                session.setAttribute("sectionId",sectionId);
                return JSON.toJSONString(roleInfo.getRoleTypeId());
            }else {
                return JSON.toJSONString("科室类型编号错误");
            }
        }
    }
}
