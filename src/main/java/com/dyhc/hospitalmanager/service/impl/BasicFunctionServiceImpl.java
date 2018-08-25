package com.dyhc.hospitalmanager.service.impl;

import com.dyhc.hospitalmanager.dao.*;
import com.dyhc.hospitalmanager.pojo.*;
import com.dyhc.hospitalmanager.pojo.Package;
import com.dyhc.hospitalmanager.service.BasicFunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BasicFunctionServiceImpl implements BasicFunctionService {

    private Logger logger= LoggerFactory.getLogger(BasicFunctionService.class);
    @Autowired
    private SectionMapper sectionMapper;
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CombinationMapper combinationMapper;
    @Autowired
    private PackageMapper packageMapper;
    @Autowired
    private CommonResultsMapper commonResultsMapper;
    @Autowired
    private ProposedDescriptionMapper proposedDescriptionMapper;

    //----------------------------------科室维护
    @Override
    public int addSectionInfo(Section section) {
        int result=0;
        try {
            result=sectionMapper.addSectionInfo(section);
        } catch (Exception e) {
            logger.error("科室添加错误!");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updSectionInfo(Section section) {
        int result=0;
        try {
            result=sectionMapper.updSectionInfo(section);
        } catch (Exception e) {
            logger.error("科室修改错误!");
            e.printStackTrace();
        }
        return result;
    }


    //----------------------------------体检项维护

    @Override
    public List<Check> getAllCheckList() {
        return null;
    }

    @Override
    public int addCheckInfo(Check check) {
        int result=0;
        try {
            result=checkMapper.addCheckInfo(check);
        } catch (Exception e) {
            logger.error("体检项添加错误");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updCheckInfo(Check check) {
        int result=0;
        try {
            result=checkMapper.updCheckInfo(check);
        } catch (Exception e) {
            logger.error("体检项修改错误");
            e.printStackTrace();
        }
        return result;
    }




    //----------------------------------组合项项维护

    @Override
    public int addCombinationInfo(Combination combination,List<Check>checkList) {
        int result=0;
        try {
            result=combinationMapper.addCombinationInfo(combination);
        } catch (Exception e) {
            logger.error("组合项添加失败!");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updCombinationInfo(Combination combination) {
        int result=0;
        try {
            result=combinationMapper.updCombinationInfo(combination);
        } catch (Exception e) {
            logger.error("组合项修改失败!");
            e.printStackTrace();
        }
        return result;
    }


    //----------------------------------套餐项维护
    @Override
    public int addPackageInfo(Package pack,List<Combination> combinationList,List<Check> checkList) {
        int result=0;
        try {
            result=packageMapper.addPackageInfo(pack);
        } catch (Exception e) {
            logger.error("添加套餐失败!");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updPackageInfo(Package pack) {
        int result=0;
        try {
            result=packageMapper.updPackageInfo(pack);
        } catch (Exception e) {
            logger.error("添加套餐失败!");
            e.printStackTrace();
        }
        return result;
    }


    //----------------------------------常见结果维护

    @Override
    public int addCommonResultsInfo(CommonResults commonResults) {
        int result=0;
        try {
            result=commonResultsMapper.addCommonResultsInfo(commonResults);
        } catch (Exception e) {
            logger.error("添加常见结果失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updCommonResultsInfo(CommonResults commonResults) {
        int result=0;
        try {
            result=commonResultsMapper.updCommonResultsInfo(commonResults);
        } catch (Exception e) {
            logger.error("修改常见结果失败");
            e.printStackTrace();
        }
        return result;
    }


    //----------------------------------建议描述维护

    @Override
    public int addProposedDescriptionInfo(ProposedDescription proposedDescription) {
        int result=0;
        try {
            result=proposedDescriptionMapper.addProposedDescriptionInfo(proposedDescription);
        } catch (Exception e) {
            logger.error("添加建议描述失败!");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updProposedDescriptionInfo(ProposedDescription proposedDescription) {
        int result=0;
        try {
            result=proposedDescriptionMapper.updProposedDescriptionInfo(proposedDescription);
        } catch (Exception e) {
            logger.error("修改建议描述失败!");
            e.printStackTrace();
        }
        return result;
    }
}
