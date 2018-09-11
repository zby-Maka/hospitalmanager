package com.dyhc.hospitalmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *文件路映射径配置
 */
@Component
@Configuration
public class FilePathConfigration implements WebMvcConfigurer {

    public static String filePathMapper;

    public static String absloutePath;

    @Value("${file.filePathMapper}")
    public void setFilePathMapper(String filePathMapper) {
        FilePathConfigration.filePathMapper = filePathMapper;
    }

    @Value("${file.linuxAbsloutePath}")
    public void setAbsloutePath(String absloutePath) {
        FilePathConfigration.absloutePath = absloutePath;
    }

    /**
     * 映射linux虚拟路径到项目下的excelfile目录
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(filePathMapper).addResourceLocations("file:"+absloutePath+"");
    }
}
