package com.dyhc.hospitalmanager.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("**")
                .excludePathPatterns("/static/**");
               /* .excludePathPatterns("/code/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/font/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/lay/**")
                .excludePathPatterns("/style/**")
                .excludePathPatterns("/scripts/**")
                .excludePathPatterns("/templates/**")
                .excludePathPatterns("/login.do")
                .excludePathPatterns("/Thebackend-page/guideList.html")
                .excludePathPatterns("/booking.html")
                .excludePathPatterns("/Thebackend-page/thewaylist.html")
                .excludePathPatterns("/check.html")
                .excludePathPatterns("/login.html");*/
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowCredentials(true)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE")//设置允许的方法
                .maxAge(3600);//跨域允许时间
    }

}
