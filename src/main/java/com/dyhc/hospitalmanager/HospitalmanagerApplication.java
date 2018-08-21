package com.dyhc.hospitalmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dyhc.hospitalmanager.dao")
public class HospitalmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalmanagerApplication.class, args);
    }
}
