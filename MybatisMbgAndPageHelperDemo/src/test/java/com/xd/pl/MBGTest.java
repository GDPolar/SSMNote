package com.xd.pl;

import com.xd.pl.mapper.EmpMapper;
import com.xd.pl.pojo.Emp;
import com.xd.pl.pojo.EmpExample;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MBGTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 无条件，即查询所有
        List<Emp> emps1 = mapper.selectByExample(null);
        emps1.forEach(System.out::println);
        // 通过条件查询
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andDeptIdLessThan(3).andEmpIdBetween(2,3);
        empExample.or().andDeptIdEqualTo(1);
        List<Emp> emps2 = mapper.selectByExample(empExample);
        emps2.forEach(System.out::println);
    }
}
