package com.dyhc.hospitalmanager.util;

import com.dyhc.hospitalmanager.pojo.Permissions;
import com.dyhc.hospitalmanager.pojo.RoleInfo;
import com.dyhc.hospitalmanager.service.PermissionsService;
import com.dyhc.hospitalmanager.service.RoleInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *shiro数据域
 * @author ドゥシウ
 * 2018-9-18
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private PermissionsService permissionsService;

    /**
     * User authentication(认证)
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        Subject subject=SecurityUtils.getSubject();
        Session session=subject.getSession();
        UsernamePasswordToken userToken=(UsernamePasswordToken)authenticationToken;
        //获取用户名
        String userName=userToken.getUsername();
        RoleInfo roleInfo=null;
        try {
            roleInfo=roleInfoService.getRoleInfoLogin(userName,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //事先处理，如果用户不存在，直接返回null
        if(roleInfo==null){
            return null;
        }else {
            if (roleInfo.getSectionId()!= null) {
                session.setAttribute("sectionId",roleInfo.getSectionId());
            }
            session.setAttribute("roleInfo", roleInfo);
        }
        //根据用户情况，构建AuthenticationInfo对象返回
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(roleInfo,roleInfo.getPassword(),getName());
        return simpleAuthenticationInfo;
    }

    /**
     *The user authorization(授权)
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户
        RoleInfo user=(RoleInfo)principalCollection.getPrimaryPrincipal();
        //创建权限实例
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        try {
            //角色权限集合
            List<String> rolePermissions=new ArrayList<String>();
            RoleInfo roleInfo=roleInfoService.getRoleInfoLogin(user.getUserName(),null);
            List<Permissions> permissions=permissionsService.getPermissions(roleInfo.getRoleInfoId());
            for(Permissions per:permissions){
                rolePermissions.add(per.getResourcePath());
            }
            //添加用户角色
            simpleAuthorizationInfo.addRole(user.getUserName());
            //添加角色对应的所有权限
            simpleAuthorizationInfo.addStringPermissions(rolePermissions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }
}
