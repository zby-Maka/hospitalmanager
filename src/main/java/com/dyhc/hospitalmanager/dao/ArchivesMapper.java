package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Archives;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 档案接口
 * ycy
 */
public interface ArchivesMapper {

    /**
     * 根据用户id查询档案信息
     * author ycy
     * @return
     */
    List<Archives>getArchivesByPerssonId(@Param("personId")Integer personId) throws  Exception;

    /**
     * 查询档案最后一位倒序
     * @return
     * author ycy
     * @throws Exception
     */
    Archives getArchivesIdByDesc() throws Exception;


}
