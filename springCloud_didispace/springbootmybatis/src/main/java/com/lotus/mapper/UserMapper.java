package com.lotus.mapper;

import com.lotus.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhusheng on 2017/6/13 0013.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(AGE, NAME) VALUES(#{age}, #{name})")
    int insert(@Param("name") String name,@Param("age") Integer age);
}
