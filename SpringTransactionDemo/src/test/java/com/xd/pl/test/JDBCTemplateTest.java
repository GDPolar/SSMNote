package com.xd.pl.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

// 引用了 org.springframework.spring-test 依赖
// 让测试运行于 Spring 测试环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        String sql = "select * from t_user where id = ?";
        jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
    }
}
