package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.pojo.Section;
import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
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
    @ResponseBody
    public String getLogin(String userName, String password, Integer roletypeid, HttpServletRequest request) throws  Exception {
        String json = "";
        //获取用户实例
        Subject subject=SecurityUtils.getSubject();
        //判断当前用户是否通过认证
        if(!subject.isAuthenticated()){
            //如果未认证，就将用户名和密码封装成UsernamePasswordToken对象
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,password);
            //将用户的token存放与sessionManager中，让shiro记住该用户
            usernamePasswordToken.setRememberMe(true);

            try {
                //执行登录
                subject.login(usernamePasswordToken);
                json="{\"userName\":\""+userName+"\",\"state\":\"ok\"}";

                //账号错误exception
            }catch (UnknownAccountException e){
                json="{\"state\":\"账号不存在！\"}";

                //密码错误exception
            } catch (IncorrectCredentialsException e){
                json="{\"state\":\"密码错误！\"}";

                //用户不存在exception
            }catch (AuthenticationException e) {
                json="{\"state\":\"账号异常！\"}";

            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            json="{\"state\":\"您已登录，无需重复登录！\"}";
        }
        return json;
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
