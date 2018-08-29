package com.dyhc.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转后台页面
 */
@Controller
public class SendBackstageController {

    @GetMapping("/Thebackend-page/AlwaysCheck.html")
    public String Alway(){
        return "/Thebackend-page/AlwaysCheck";
    }

    @GetMapping("/Thebackend-page/Cashiers.html")
    public String Cashiers(){
        return "/Thebackend-page/Cashiers";
    }

    @GetMapping("/Thebackend-page/refund.html")
    public String Refund(){
        return "/Thebackend-page/refund";
    }

    @GetMapping("/Thebackend-page/department.html")
    public String Department(){
        return "/Thebackend-page/department";
    }

    @GetMapping("/Thebackend-page/Laboratory.html")
    public String Laboratory(){
        return "/Thebackend-page/Laboratory";
    }

    @GetMapping("/Thebackend-page/tjx.html")
    public String Tjx(){
        return "/Thebackend-page/tjx";
    }

    @GetMapping("/Thebackend-page/zhx.html")
    public String Zhx(){
        return "/Thebackend-page/zhx";
    }

    @GetMapping("/Thebackend-page/keshiweihu.html")
    public String KeshiWeiHu(){
        return "/Thebackend-page/keshiweihu";
    }

    @GetMapping("/Thebackend-page/tc.html")
    public String Tc(){
        return "/Thebackend-page/tc";
    }

    @GetMapping("/Thebackend-page/danweifenuzu.html")
    public String DangWeiFenZu(){
        return "/Thebackend-page/danweifenuzu";
    }

    @GetMapping("/Thebackend-page/unit.html")
    public String Unit(){
        return "/Thebackend-page/unit";
    }
    @GetMapping("/Thebackend-page/jieguojianyi.html")
    public String jieguojianyi(){
        return "/Thebackend-page/jieguojianyi";
    }
}
