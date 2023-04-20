package com.xd.pl.mapper;

import com.xd.pl.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    // @param 自定义 sql 语句中用的变量名称
    User getUserById(@Param("id") Integer id);

    User getUserByUsername(@Param("username") String username);

    Map<String, Object> getUserByUsernameToMap(@Param("username") String username);

    List<Map<String, Object>> getAllUsersToMap1();

    // @MapKey 注解
    // 将得到的多个 map 对象作为 value 存入外层 map，并以 MapKey 指定的字段的值作为外层 map 的 key
    @MapKey("username")
    Map<String, Object> getAllUsersToMap2();

    List<User> getAllUsers();

    List<User> likeSelect(@Param("mohu") String mohu);

    void insertUserAndGetGeneratedKeys(User user);

    Integer countUsers();
}
