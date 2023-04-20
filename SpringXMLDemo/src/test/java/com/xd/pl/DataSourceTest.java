package com.xd.pl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void test1() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");
        DruidDataSource datasource = ioc.getBean("datasource", DruidDataSource.class);
        DruidPooledConnection connection = datasource.getConnection();
        System.out.println(datasource);
    }

}
