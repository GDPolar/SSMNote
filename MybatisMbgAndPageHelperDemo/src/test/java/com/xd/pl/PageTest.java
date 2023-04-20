package com.xd.pl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.pl.mapper.EmpMapper;
import com.xd.pl.pojo.Emp;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PageTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // PageHelper.startPage() 实现分页查询
        // 此时 page 和 emps 实质上为同一对象
        Page<Object> page = PageHelper.startPage(2, 4);
        List<Emp> emps = mapper.selectByExample(null);
        // 获取相关信息
        PageInfo<Emp> pageInfo = new PageInfo<>(emps);
        emps.forEach(System.out::println);
        System.out.println(page);
        System.out.println(pageInfo);

    }
}
