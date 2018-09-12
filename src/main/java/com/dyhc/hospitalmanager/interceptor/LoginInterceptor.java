package com.dyhc.hospitalmanager.interceptor;


import com.dyhc.hospitalmanager.pojo.RoleInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 登陆拦截器
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //角色权限集合
    private static final Map<Integer,List<String>> rolePermissions=new HashMap<Integer, List<String>>();
    //初始化角色权限
    static {
        List<String> adminPermissions=new ArrayList<String>();//系统管理员访问权限
        List<String> chargePermissions=new ArrayList<String>();//收费处访问权限
        List<String> checkPermissions=new ArrayList<String>();//检查科室访问权限
        List<String> inspectionPermissions=new ArrayList<String>();//检验科室访问权限
        List<String> alwaysCheckPermissions=new ArrayList<String>();//总检访问权限

        adminPermissions.add("index.html");
        adminPermissions.add("Thebackend-page/keshiweihu.html");
        adminPermissions.add("Thebackend-page/tjx.html");
        adminPermissions.add("Thebackend-page/zhx.html");
        adminPermissions.add("Thebackend-page/tc.html");
        adminPermissions.add("Thebackend-page/jy.html");
        adminPermissions.add("Thebackend-page/jieguojianyi.html");
        adminPermissions.add("Thebackend-page/unit.html");
        adminPermissions.add("Thebackend-page/danweifenuzu.html");

        chargePermissions.add("CashiersIndex.html");
        chargePermissions.add("Thebackend-page/refund.html");
        chargePermissions.add("Thebackend-page/Cashiers.html");

        checkPermissions.add("Thebackend-page/department.html");

        inspectionPermissions.add("Thebackend-page/Laboratory.html");

        alwaysCheckPermissions.add("AlwaysCheckIndex.html");
        alwaysCheckPermissions.add("Thebackend-page/total.html");
        alwaysCheckPermissions.add("Thebackend-page/AlwaysCheck.html");

        rolePermissions.put(1,adminPermissions);
        rolePermissions.put(2,checkPermissions);
        rolePermissions.put(3,inspectionPermissions);
        rolePermissions.put(4,alwaysCheckPermissions);
        rolePermissions.put(5,chargePermissions);
    }


    /**
     * 进行url权限拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        RoleInfo roleInfo=(RoleInfo) request.getSession().getAttribute("roleInfo");
        //获取请求url
        String url=request.getRequestURI();
        if (roleInfo==null){
            response.sendRedirect("/hospitalOne/login.html");
            return false;
        }else {
            if(url.indexOf(".html")>0){
                Boolean flag=false;
            /*Integer statrIndex=url.indexOf("One")+4;
            String newUrl=url.substring(statrIndex);*/
                switch (roleInfo.getRoleTypeId()){
                    case 1:
                        for (String location:LoginInterceptor.rolePermissions.get(roleInfo.getRoleTypeId())){
                            if(url.indexOf(location)>0){
                                flag=true;
                            }
                        }
                        break;
                    case 2:
                        if("wk".equals(roleInfo.getUserName())){
                            for (String location:LoginInterceptor.rolePermissions.get(2)){
                                if(url.indexOf(location)>0){
                                    flag=true;
                                }
                            }
                        }else if("nk".equals(roleInfo.getUserName())){
                            for (String location:LoginInterceptor.rolePermissions.get(3)){
                                if(url.indexOf(location)>0){
                                    flag=true;
                                }
                            }
                        }else if("gnk".equals(roleInfo.getUserName())){
                            for (String location:LoginInterceptor.rolePermissions.get(3)){
                                if(url.indexOf(location)>0){
                                    flag=true;
                                }
                            }
                        }
                        break;
                    case 3:
                        for (String location:LoginInterceptor.rolePermissions.get(4)){
                            if(url.indexOf(location)>0){
                                flag=true;
                            }
                        }
                        break;
                    case 4:
                        for (String location:LoginInterceptor.rolePermissions.get(5)){
                            if(url.indexOf(location)>0){
                                flag=true;
                            }
                        }
                        break;
                }
                if(!flag){
                    response.sendRedirect("/hospitalOne/login.html");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws  Exception {

    }
}
