package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckMapper {
    /**wjj
     * 科室是检验:根据体检项id查出体检项数据，与接收的数据对比
     * @param checkId
     * @return
     */
    List<Check> getCheckById(@Param("checkId")Integer checkId)throws Exception;
    /**
     * 根据体检编号，查询人员体检项 白文鑫
     * @param physicalExaminationAndCombinationId
     * @return
     * @throws Exception
     */
    List<Check>  getCheckList(@Param("physicalExaminationAndCombinationId")Integer physicalExaminationAndCombinationId) throws  Exception;

    /**
     * 查询所有的体检项
     * zby
     * @return
     */
    List<Check> getAllCheckList() throws Exception;

    /**
     * 添加体检项信息
     * @param check
     * @return
     */
    int addCheckInfo(Check check);

    /**
     * 修改体检项信息
     * @param check
     * @return
     */
    int updCheckInfo(Check check);

    /**王娇娇
     * 根据体检编号查询人员在该科室下的体检项
     * @param peacId
     * @return
     * @throws Exception
     */
    List<Check>  getPersonCheckBySectionId(@Param("peacId")String peacId,@Param("sectionId")Integer sectionId) throws  Exception;
}
