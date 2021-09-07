package com.pyyexclusivenew.pyy.mapper;

import com.pyyexclusivenew.pyy.entity.Jurisdiction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("JurisdictionMapper")
public interface JurisdictionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jurisdiction record);

    Jurisdiction selectByPrimaryKey(Integer id);

    List<Jurisdiction> selectAll();

    int updateByPrimaryKey(Jurisdiction record);

    @Select("select * from jurisdiction where id = #{id}")
    Jurisdiction selectById(Integer id);
}