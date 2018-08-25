package com.dyhc.hospitalmanager.dao;

import com.dyhc.hospitalmanager.pojo.Archives;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 档案接口
 *
 */
@Mapper
@Repository
public interface ArchivesMapper {

    /**
     * 根据用户id查询档案信息
     * @return
     */
    List<Archives>getArchivesByPerssonId(@Param("personId")Integer personId) throws  Exception;

    /**
     * 查询档案最后一位倒序
     * @return
     * @throws Exception
     */
    Archives getArchivesIdByDesc() throws Exception;


    /**
     * 添加档案表信息
     * @param archives
     * @return
     * @throws Exception
     */
    int addArchivesInfo(Archives archives)throws  Exception;


}
