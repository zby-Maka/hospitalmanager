package com.dyhc.hospitalmanager.dao;
import com.dyhc.hospitalmanager.pojo.SectionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SectionTypeMapper {
    /**
     * 根据session作用域传过来的科室id获取可是类型名称
     * @param sectionId
     * @return
     */
    SectionType getSectionTypeName(@Param("sectionId")Integer sectionId);

}
