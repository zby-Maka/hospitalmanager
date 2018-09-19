package com.dyhc.hospitalmanager.config;

import com.dyhc.hospitalmanager.util.ShiroRealm;
import jdk.nashorn.internal.runtime.RewriteException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * shiro Security framework configuration
 * @author ドゥシウ
 * 2018-9-18
 */
@Configuration
public class ShiroConfiguration {


    /**
     *Register realm to security manager
     * @return
     */
    @Bean
    public ShiroRealm registeredSecurityManager(){
        ShiroRealm shiroRealm=new ShiroRealm();
        //Set the shiro password matcher
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroRealm;
    }


    /**
     * Configure the security certification manager
     */
    @Bean
    public SecurityManager setSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        //Set up a realm data source
        defaultWebSecurityManager.setRealm(registeredSecurityManager());
        return defaultWebSecurityManager;
    }

    /**
     * Filter factory, set the corresponding filter conditions and jump conditions
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean setShiroFilterFactoryBean(SecurityManager securityManager){
        //Create the ShiroFilterFactoryBean factory
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //set SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //Create a collection of filter conditions
        Map<String,String> filters=new HashMap<String,String>();

        //Configuring static resources
        filters.put("/code/**","anon");
        filters.put("/css/**","anon");
        filters.put("/font/**","anon");
        filters.put("/images/**","anon");
        filters.put("/img/**","anon");
        filters.put("/js/**","anon");
        filters.put("/lay/**","anon");
        filters.put("/style/**","anon");
        filters.put("/scripts/**","anon");
        filters.put("/templates/**","anon");
        filters.put("/codefile/**","anon");
        filters.put("/admin/**","anon");
        filters.put("/*.do","anon");
        filters.put("/PhysicalPersonInfo.xlsx","anon");
        filters.put("/Thebackend-page/guideList.html","anon");
        filters.put("/Thebackend-page/DanWeiGuide.html","anon");
        filters.put("/Thebackend-page/thewaylist.html","anon");
        filters.put("/check.html","anon");
        filters.put("/login.html","anon");
        filters.put("/booking.html","anon");


        //admin permissions configuration
        filters.put("/index.html","roles[admin],perms[index.html]");
        filters.put("/Thebackend-page/keshiweihu.html","roles[admin],perms[Thebackend-page/keshiweihu.html]");
        filters.put("/Thebackend-page/tjx.html","roles[admin],perms[Thebackend-page/tjx.html]");
        filters.put("/Thebackend-page/zhx.html","roles[admin],perms[Thebackend-page/zhx.html]");
        filters.put("/Thebackend-page/tc.html","roles[admin],perms[Thebackend-page/tc.html]");
        filters.put("/Thebackend-page/jy.html","roles[admin],perms[Thebackend-page/jy.html]");
        filters.put("/Thebackend-page/jieguojianyi.html","roles[admin],perms[Thebackend-page/jieguojianyi.html]");
        filters.put("/Thebackend-page/unit.html","roles[admin],perms[Thebackend-page/unit.html]");
        filters.put("/Thebackend-page/danweifenuzu.html","roles[admin],perms[Thebackend-page/danweifenuzu.html]");
        filters.put("/Thebackend-page/GroupInfos.html","roles[admin],perms[Thebackend-page/GroupInfos.html]");

        //check department permissions configuration
        filters.put("/Thebackend-page/department.html","roles[wk],perms[Thebackend-page/department.html]");

        //Inspection department permissions configuration
        filters.put("/Thebackend-page/Laboratory.html","roles[nk],perms[Thebackend-page/Laboratory.html]");

        //Always check permissions configuration
        filters.put("/AlwaysCheckIndex.html","roles[zzys],perms[AlwaysCheckIndex.html]");
        filters.put("/Thebackend-page/total.html","roles[zzys],perms[Thebackend-page/total.html]");
        filters.put("/Thebackend-page/AlwaysCheck.html","roles[zzys],perms[Thebackend-page/AlwaysCheck.html]");

        //cost permissions configuration
        filters.put("/CashiersIndex.html","roles[fyc],perms[CashiersIndex.html]");
        filters.put("/Thebackend-page/refund.html","roles[fyc],perms[Thebackend-page/refund.html]");
        filters.put("/Thebackend-page/Cashiers.html","roles[fyc],perms[Thebackend-page/Cashiers.html]");

        //Warning: intercepts all unauthenticated requests, and this configuration item must be last
        //filters.put("/**","authc");

        //set login page
        shiroFilterFactoryBean.setLoginUrl("/login.html");

        //Set access insufficient jump path
        shiroFilterFactoryBean.setUnauthorizedUrl("/logout.do");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filters);
        return shiroFilterFactoryBean;
    }

    //The use of adding an annotation, this annotation does not take effect
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
