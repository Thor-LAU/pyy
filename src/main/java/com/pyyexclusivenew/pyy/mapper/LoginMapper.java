package com.pyyexclusivenew.pyy.mapper;

import com.pyyexclusivenew.pyy.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 17:08
 * @Desc LoginMapper
 */
@Mapper
@Component("LoginMapper")
public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    Login selectByPrimaryKey(Integer id);

    List<Login> selectAll();

    int updateByPrimaryKey(Login record);

    @Select("select * from login where name = #{name}")
    List<Login> selectByName(String name);
}