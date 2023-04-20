package com.xd.pl.mapper;

import com.xd.pl.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser1();

    int updateUser();

    User getUserByUsernameAndId(String username, int id);

    // 用 map 集合自定义参数名
    User checkLogin(Map<String, Object> map);

    // 参数为实体类类型的参数，通过 getter 和 setter 的名字获取
    int insertUser2(User user);

    // 利用注解的方式自定义
    int insertUser3(@Param("usernameAA") String username,
                    @Param(value = "passwordAA") String password,
                    @Param("idAA") int id);

    List<User> getAllUsers();

}
