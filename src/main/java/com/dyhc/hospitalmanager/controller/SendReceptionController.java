package com.dyhc.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 跳转前台页面
 */
@Controller
public class SendReceptionController {

    @GetMapping("/booking.html")
    public String sendBooking(){
        return "Thefrontend-page/booking";
    }

    @GetMapping("/check.html")
    public String sendCheck(){
        return "Thefrontend-page/check";
    }

    @GetMapping("/houseEdit.html")
    public String sendHouseEdit(){
        return "Thefrontend-page/house_edit";
    }

    @GetMapping("/houseList.html")
    public String sendHouseList(){
        return "Thefrontend-page/house_list";
    }

    @GetMapping("/introduce.html")
    public String sendIntroduce(){
        return "Thefrontend-page/introduce";
    }

    @GetMapping("/login.html")
    public String sendLogin(HttpSession session) {
        session.invalidate();
        return "Thefrontend-page/login";
    }

    @GetMapping("/loupanchart.html")
    public String sendLoupanchart(){
        return "Thefrontend-page/loupanchart";
    }

    @GetMapping("/index.html")
    public String sendIndex(){
        return "Thefrontend-page/index";
    }

    @GetMapping("DepartmentIndex.html")
    public String sendDepartmentIndex(){
        return "Thefrontend-page/DepartmentIndex";
    }

    @GetMapping("/CashiersIndex.html")
    public String sendCashiersIndex(){
        return "Thefrontend-page/CashiersIndex";
    }

    @GetMapping("AlwaysCheckIndex.html")
    public String snedAlwaysCheckIndex(){
        return "Thefrontend-page/AlwaysCheckIndex";
    }

    @GetMapping("/LaboratoryIndex.html")
    public String sendLaboratoryIndex(){
        return "Thefrontend-page/LaboratoryIndex";
    }

}
