package com.lab.mapper;

import com.lab.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 根据用户名查询用户对象
 * @param
 *
 */
public interface UserMapper {
    @Select("select * from tb_brand where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);
    @Select("select * from tb_brand where username = #{username}")
    User selectByUsername(String username);
    @Insert("insert into tb_brand values (null,#{username},#{password})")
    void add(User user);
}
