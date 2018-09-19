package com.dyhc.hospitalmanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyhc.hospitalmanager.pojo.Combination;
import com.dyhc.hospitalmanager.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CombinationController {

    @Autowired
    private CombinationService combinationService;

    @GetMapping("/getAllCombinationList")
    public List<Combination> getAllCombinationList() {
        return combinationService.getAllCombinationList();
    }

    @RequestMapping("/getCheckByComArrayIds.do")
    public List<Combination> getCheckByComArrayId(@RequestBody JSONObject json) throws Exception {

        JSONArray zhx=json.getJSONArray("comIds");
        Integer[] comIds=null;
        if (zhx.size()!=0){
            String tjcjson=JSON.toJSONString(zhx);
            List<Integer> number1=JSONObject.parseArray(tjcjson,Integer.class);
            comIds=new Integer[number1.size()];
            for (int i = 0;i<number1.size();i++){
                comIds[i]=number1.get(i);
            }
        }
        return combinationService.getCheckByComArrayId(comIds);
    }
}
