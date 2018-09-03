    package com.dyhc.hospitalmanager.service.impl;
    import org.apache.poi.hssf.usermodel.HSSFWorkbook;
    import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    import org.springframework.util.ResourceUtils;
    import org.springframework.web.multipart.MultipartFile;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.InputStream;
    import java.io.UnsupportedEncodingException;
    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class ExcelServiceImpl {

        /**
         * 下载Excel模板
         */
            public File buildXlsById() throws UnsupportedEncodingException {
                //do something to find this file
                File file=null;
                String fileName = "PhysicalPersonInfo";

                try {
                    fileName=new String(fileName.getBytes(),"utf-8");
                    file = ResourceUtils.getFile("classpath:static/excelmodel/"+fileName+".xlsx");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                return file;
            }


    }
