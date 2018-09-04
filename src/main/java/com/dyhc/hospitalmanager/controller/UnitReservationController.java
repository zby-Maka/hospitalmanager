package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyhc.hospitalmanager.dao.GroupMapper;
import com.dyhc.hospitalmanager.pojo.CompanyInfo;
import com.dyhc.hospitalmanager.pojo.Group;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.UnitReservationService;
import com.dyhc.hospitalmanager.service.impl.ExcelServiceImpl;
import com.dyhc.hospitalmanager.util.ImportExcelUtil;
import com.dyhc.hospitalmanager.util.ResponseUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @RequestMapping("/admin/model.do")
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

    /**
     * 解析上传的Excel
     * @return
     */
    @RequestMapping("/uploadPersonInfo.do")
    @ResponseBody
    public String showPersonInfo(@RequestParam("companyName") String companyName){
        File cfgFile = null;
            File file1 = new File("./src/main/resources/excelfile/"+companyName+".xlsx");
            //cfgFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "excelfile/"+companyName+".xlsx");
        ImportExcelUtil importExcelUtil=new ImportExcelUtil();
        File file=new File(String.valueOf(file1));
        List<PersonInfo> info = new ArrayList<>();
        try {
            InputStream in=new FileInputStream(file);
            List<List<Object>> infos=importExcelUtil.getBankListByExcel(in,file.getName());
            for (List<Object> str:infos){
                PersonInfo c = new PersonInfo();
                c.setPersonName((String) str.get(0));
                System.out.println();
                String a = (String) str.get(1);
                c.setPersonAge(Integer.parseInt(a));
                String bir = (String) str.get(2);
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bir);
                c.setPersonBirthday(date);
                c.setPersonSex((String) str.get(3));
                c.setPersonIdCard((String) str.get(4));
                c.setIsMarry((String) str.get(5));
                c.setPersonTelephone((String) str.get(6));
                c.setPersonAddress((String) str.get(7));
                c.setPersonNameSpellCode((String) str.get(8));
                info.add(c);
            }
            System.out.println(info.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(info);
    }

    /**
     * 添加分组信息并且对人员信息进行添加
     * @param str
     * @return
     */
    @RequestMapping("/uploadGroupPerson.do")
    @ResponseBody
    public String addGroupPerson(@RequestBody JSONObject str){
        JSONArray jsonArray = str.getJSONArray("persionarray");
        Object obj=jsonArray.get(jsonArray.size()-1);
        String json=JSON.toJSONString(obj);
        Group group=JSONObject.parseObject(json,Group.class);
        jsonArray.remove(jsonArray.size()-1);
        String json2=jsonArray.toJSONString();
        List<PersonInfo> personInfos=JSONObject.parseArray(json2,PersonInfo.class);
        System.out.println("身份证号:"+personInfos.get(0).getPersonIdCard());
        //添加方法
        Integer result = unitReservationService.addGroupAndPersonInfo(group,personInfos);
        Integer perG = 0;
        if(result>0){
            perG = 1;
        }
        return JSON.toJSONString(perG);

    }


    /**
     * 对公司信息进行是否删除的修改
     * @param
     * @return
     */
    @RequestMapping("/updIsDel.do")
    @ResponseBody
    public String updIsDel(@RequestParam("companyId") Integer companyId,@RequestParam("isDelete")Integer isDelete){
        System.out.println("公司id:"+companyId+"====是否删除:"+isDelete);
        Integer content = 0;
        Integer result = unitReservationService.updIsDel(companyId,isDelete);
        if(result > 0){
            content = 1;
        }
        return JSON.toJSONString(content);
    }

    /**
     * 根据分组id显示所有分组信息
     * @param groupId
     * @param companyId
     * @return
     */
    @RequestMapping("/showGroup.do")
    @ResponseBody
    public String showGroupDetails(@RequestParam("groupId") Integer groupId,@RequestParam("companyId")Integer companyId){
        Group group = unitReservationService.showGroupDetails(groupId);
        return JSON.toJSONString(group);
    }


    /**
     * 对分组信息进行是否删除的修改
     * @param
     * @return
     */
    @RequestMapping("/updGroupIsDel.do")
    @ResponseBody
    public String updGroupIsDel(@RequestParam("isDelete")Integer isDelete,@RequestParam("groupId") Integer groupId){
        Integer content = 0;
        Integer result = unitReservationService.updGroup(isDelete,groupId);
        if(result > 0){
            content = 1;
        }
        return JSON.toJSONString(content);
    }
}
