package com.xd.pl;

import com.xd.pl.mapper.UserMapper;
import com.xd.pl.pojo.User;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void test1() throws IOException {
        // 套路
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // sqlSession 是 Mybatis 提供的操作数据库的对象
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        // 获取 UserMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.insertUser1();
        System.out.println(res);

        // 提交事务
        // sqlSession.commit();
        // 或者在获取 sqlSession 设置自动提交参数为 true
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.updateUser();
        System.out.println(res);
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getUserByUsernameAndId("ls", 2));
        System.out.println("--------------------");
        Map<String, Object> map = new HashMap<>();
        map.put("usernameMM", "ls");
        map.put("passwordMM", "222");
        map.put("idMM", 2);
        System.out.println(mapper.checkLogin(map));
        System.out.println("--------------------");
        List<User> userList = mapper.getAllUsers();
        userList.forEach(System.out::println);
    }

    @Test
    public void test4() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User("ww", "333", 3);
        int res1 = mapper.insertUser2(user1);
        System.out.println(res1);
        int res2 = mapper.insertUser3("xx", "555", 5);
        System.out.println(res2);
    }
}
