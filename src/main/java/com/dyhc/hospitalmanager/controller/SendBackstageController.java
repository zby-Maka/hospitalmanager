package com.dyhc.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转后台页面
 */
@Controller
public class SendBackstageController {

    @GetMapping("/AlwaysCheck.html")
    public String sendAlwaysCheck(){ return "Thebackend-page/AlwaysCheck"; }
    @GetMapping("/Cashiers.html")
    public String sendCashiers(){
        return "Thebackend-page/Cashiers";
    }
    @GetMapping("/department.html")
    public String sendDepartment(){
        return "Thebackend-page/department";
    }
    @GetMapping("/backstageIndex.html")
    public String sendIndex(){
        return "Thebackend-page/index";
    }
    @GetMapping("/jieguojianyi.html")
    public String sendJieguojianyi(){
        return "Thebackend-page/jieguojianyi";
    }
    @GetMapping("/jy.html")
    public String sendJy(){
        return "Thebackend-page/jy";
    }
    @GetMapping("/keshiweihu.html")
    public String sendKeshiweihu(){
        return "Thebackend-page/keshiweihu";
    }
    @GetMapping("/refund.html")
    public String sendRefund(){
        return "Thebackend-page/refund";
    }
    @GetMapping("/tc.html")
    public String sendTc(){
        return "Thebackend-page/tc";
    }
    @GetMapping("/tjx.html")
    public String sendTjx(){
        return "Thebackend-page/tjx";
    }
    @GetMapping("/total.html")
    public String sendTotal(){
        return "Thebackend-page/total";
    }
    @GetMapping("/zhx.html")
    public String sendZhx(){
        return "Thebackend-page/zhx";
    }

    @GetMapping("danweifenuzu.html")
    public String danweifenuzu(){
        return "Thebackend-page/danweifenuzu";
    }
}
