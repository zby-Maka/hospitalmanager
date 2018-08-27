package com.dyhc.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/receptionIndex.html")
    public String sendIndex(){
        return "Thefrontend-page/index";
    }

    @GetMapping("/introduce.html")
    public String sendIntroduce(){
        return "Thefrontend-page/introduce";
    }

    @GetMapping("/login.html")
    public String sendLogin(){
        return "Thefrontend-page/login";
    }

    @GetMapping("/loupanchart.html")
    public String sendLoupanchart(){
        return "Thefrontend-page/loupanchart";
    }
}
