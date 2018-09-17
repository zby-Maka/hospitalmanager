package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Check;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CheckMapper {

    /**
     * 根据性别查询适用的体检项
     * @param sex 性别
     * @return
     * @throws Exception
     */
    List<Check> getCheckListBySex(String sex) throws Exception;

    /**
     * 科室是检验:根据体检项id查出体检项数据，与接收的数据对比
     * @param checkId
     * @return
     */
    List<Check> getCheckById(@Param("checkId")Integer checkId)throws Exception;
    /**
     * 根据体检编号，查询人员体检项
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check>  getCheckList(@Param("physicalExaminationId")String  physicalExaminationId) throws  Exception;

    /**
     * 根据体检编号和手机号查询
     * @param physicalExaminationId
     * @param telephone
     * @return
     * @throws Exception
     */
    List<Check>  getChecks(@Param("physicalExaminationId")String  physicalExaminationId,@Param("telephone")String telephone) throws  Exception;

    /**
     * 查询所有的体检项
     * @return
     */
    List<Check> getAllCheckList() throws Exception;

    /**
     * 根据体检项id查询体检项信息
     * @return
     * @throws Exception
     */
    List<Check>getAllCheckInfoById(@Param("checkId") Integer checkId)throws Exception;

    /**
     * 添加体检项信息
     * @param check
     * @return
     */
    int addCheckInfo(Check check) throws Exception;

    /**
     * 修改体检项信息
     * @param check
     * @return
     */
    int updCheckInfo(Check check)throws Exception;

    /**
     * 根据体检编号查询人员在该科室下的体检项
     * @param peacId
     * @return
     * @throws Exception
     */
    List<Check>  getPersonCheckBySectionId(@Param("peacId")String peacId,@Param("sectionId")Integer sectionId) throws  Exception;

    /**
     * 根据体检编号查询体检项信息
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check> getCheckByPhysicalExaminationId(@Param("physicalExaminationId")String physicalExaminationId)throws Exception;

    /**
     * 根据体检编号查询所有体检项信息
     * @param physicalExaminationId
     * @return
     * @throws Exception
     */
    List<Check> getCheckByPhysicalExaminationIdList(@Param("physicalExaminationId")String physicalExaminationId,@Param("physicalStatu")Integer physicalStatu)throws Exception;

    /**
     * 根据科室编号查询体检项信息
     * @return
     */
    List<Check> getCheckListBySectionId(@Param("sectionId")Integer sectionId)throws Exception;

    /**
     * 根据组合项Id查询其下的所有体检编号
     * @param comId 组合项Id
     * @return
     */
    List<Integer> getComIdCheckId(@Param("comId") Integer[] comId);

    /**
     * 根据套餐项Id查询其下的所有体检编号
     * @param packId
     * @return
     */
    List<Integer> getPackIdCheckId(@Param("packId") Integer[] packId);
}
