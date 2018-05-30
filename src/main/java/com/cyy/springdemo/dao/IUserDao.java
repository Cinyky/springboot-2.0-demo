package com.cyy.springdemo.dao;

import com.cyy.springdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IUserDao {
    /**
     *
     * @param user
     * @return
     */
    @Insert("insert into user(name) values(#{name})")
    Boolean insertUser(User user);

    @Select("select * from user where id = #{id}")
    List<User> selectById(@Param("id")String id);

    @Select("select * from user")
    List<User> selectByAll();
}
