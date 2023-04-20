package com.xd.pl;

import com.xd.pl.mapper.DeptMapper;
import com.xd.pl.mapper.EmpMapper;
import com.xd.pl.pojo.Dept;
import com.xd.pl.pojo.Emp;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class EmpMapperTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.selectEmpById(1);
        System.out.println(emp1);
        Emp emp2 = mapper.selectEmpById2(2);
        System.out.println(emp2);
        Emp emp3 = mapper.selectEmpById3(3);
        System.out.println(emp3);
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.getEmpAndDeptByStep(1);
        System.out.println(emp1);
    }

    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept1 = mapper.getDeptAndEmpsById(2);
        System.out.println(dept1);
        Dept dept2 = mapper.getDeptAndEmpsByStep(2);
        System.out.println(dept2.getDeptId());
        // 由于懒加载，此时才执行第二步的 SQL
        System.out.println(dept2);

    }
}
