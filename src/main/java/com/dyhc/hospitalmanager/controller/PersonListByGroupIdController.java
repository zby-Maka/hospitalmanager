package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dyhc.hospitalmanager.pojo.PersonInfo;
import com.dyhc.hospitalmanager.service.PersonListByGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonListByGroupIdController {
    @Autowired
    private PersonListByGroupIdService personListByGroupIdService;

    /**
     * 查询分组下边的所有人员信息
     * @param groupId
     * @return
     */
    @RequestMapping("showListByGroupId.do")
    @ResponseBody
    public String showListByGroupId(@RequestParam("groupId") Integer groupId){
        List<PersonInfo> list = personListByGroupIdService.getPersonInfoListByGroupId(groupId);
        return JSON.toJSONString(list);
    }

}
