package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.dao.GroupMapper;
import com.dyhc.hospitalmanager.pojo.CompanyInfo;
import com.dyhc.hospitalmanager.pojo.Group;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.service.impl.ExcelServiceImpl;
import com.dyhc.hospitalmanager.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 单位预约
 */
@Controller
public class UnitReservationController {
    @Autowired
    private UnitReservationService unitReservationService;
    @Autowired
    private ExcelServiceImpl excelService;

    /**
     * 根据公司名称查询是否有公司信息
     * @param companyName 公司名称
     * @return
     */
    @RequestMapping("showCompanyInfo.do")
    @ResponseBody
    public String showCompanyInfo(@RequestParam("companyName") String companyName){
        CompanyInfo companyInfo = unitReservationService.showCompanyInfo(companyName);
        return JSON.toJSONString(companyInfo);
    }

    /**
     * 用户下载Excel模板
     * @return
     * @throws IOException
     */
    @RequestMapping("/admin/model")
    public ResponseEntity<byte[]> download2() throws IOException {
        File file = excelService.buildXlsById();
        return ResponseUtils.buildResponseEntity(file);
    }

    /**
     * 公司对信息进行修改
     * @param companyInfo
     * @return
     */
    @RequestMapping("/updCompanyInfo.do")
    @ResponseBody
    public String updCompanyInfo(CompanyInfo companyInfo){
        Integer content = 0;
        Integer result = unitReservationService.updCompanyInfo(companyInfo);
        if(result > 0){
            content = 1;
        }
        return JSON.toJSONString(content);
    }

    /**
     * 添加信息
     * @param companyInfo
     * @return
     */
    @RequestMapping("/addCompanyInfo.do")
    @ResponseBody
    public String addCompanyInfo(CompanyInfo companyInfo){
        Integer content = 0;
        Integer result = unitReservationService.addCompanyInfo(companyInfo);
        if(result > 0){
            content = 2;
        }
        return JSON.toJSONString(content);
    }


    /**
     * 用户上传Excel到指定的文件夹
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/admin/import")
    @ResponseBody
    public String addUser(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Integer content = 0;
        //上传文件保存到指定文件夹下边
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        //	String filePath = request.getSession().getServletContext().getRealPath("templates/imgupload/");
        //指定文件存放路径，可以是相对路径或者绝对路径
        String filePath = "./src/main/resources/excelfile/";
        try {
            uploadFile(file.getBytes(), filePath, fileName);
            content = 1;
        } catch (Exception e) {
            content = 3;
        }
        return JSON.toJSONString(content);
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }


    /**
     * 查询所有套餐信息
     * @return
     */
    @RequestMapping("showPackage.do")
    @ResponseBody
    public String showPackage(){
        List<Package> list = unitReservationService.showPackage();
        return JSON.toJSONString(list);
    }

    /**
     * 查询所有单位信息
     * @return
     */
    @RequestMapping("showAllCompanyInfo.do")
    @ResponseBody
    public String showCompanyInfo(){
        List<CompanyInfo> list = unitReservationService.showAllCompanyInfo();
        String json=JSON.toJSONString(unitReservationService.showAllCompanyInfo(),true);
        return JSON.toJSONString(list);
    }

    /**
     * 根据公司id查询单位分组信息
     * @param companyId
     * @return
     */
    @RequestMapping("showGroupInfo.do")
    @ResponseBody
    public String showGroupInfo(@RequestParam("companyId") Integer companyId){
        List<Group> list  = unitReservationService.groupListByCompanyId(companyId);
        return JSON.toJSONString(list);
    }

    /**
     * 根据公司id查询公司信息
     * @param companyId
     * @return
     */
    @RequestMapping("showCompanyInfoById.do")
    @ResponseBody
    public String showCompanyInfoById(@RequestParam("companyId") Integer companyId){
        CompanyInfo companyInfo = unitReservationService.showCompanyInfoById(companyId);
        return JSON.toJSONString(companyInfo);
    }



}
