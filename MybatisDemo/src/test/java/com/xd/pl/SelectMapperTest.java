package com.xd.pl;

import com.xd.pl.mapper.SelectMapper;
import com.xd.pl.pojo.User;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserByUsername("zs");
        System.out.println(user);
        Map<String, Object> res1 = mapper.getUserByUsernameToMap("zs");
        System.out.println(res1);
        System.out.println(mapper.countUsers());
        List<User> users = mapper.getAllUsers();
        System.out.println(users);
    }


    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // 作为 List 返回更常见
        List<Map<String, Object>> allUsersToMap1 = mapper.getAllUsersToMap1();
        System.out.println(allUsersToMap1);
        // 此处的 Object 实际上是 Map<String, Object>
        Map<String, Object> allUsersToMap2 = mapper.getAllUsersToMap2();
        System.out.println(allUsersToMap2);

    }


    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.likeSelect("x");
        System.out.println(users);

    }

    @Test
    public void test4() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User("qq", "777", null);
        // 由于设置了 useGeneratedKeys="true" keyProperty="id"
        // user 对象的 id 变为分配到的自增 id
        mapper.insertUserAndGetGeneratedKeys(user);
        System.out.println(user);
    }
}
