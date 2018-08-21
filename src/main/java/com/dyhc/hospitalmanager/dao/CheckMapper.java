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
}
