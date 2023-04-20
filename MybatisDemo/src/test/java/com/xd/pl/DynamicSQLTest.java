package com.xd.pl;

import com.xd.pl.mapper.DynamicSQLMapper;
import com.xd.pl.pojo.Good;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicSQLTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Good> goods1 = mapper.getGoodByCondition1(new Good(1, "", 1, 1));
        List<Good> goods2 = mapper.getGoodByCondition2(new Good(1, "", 1, 1));
        List<Good> goods3 = mapper.getGoodByCondition3(new Good(1, "", 1, 1));
        List<Good> goods4 = mapper.getGoodByCondition4(new Good(1, "", 1, 1));
        System.out.println(goods1);
        System.out.println(goods2);
        System.out.println(goods3);
        System.out.println(goods4);
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Good> goods = new ArrayList<>();
        goods.add(new Good(6, "dang" ,1, 1));
        goods.add(new Good(7, "gang" ,1, 1));
        goods.add(new Good(8, "kang" ,1, 1));
        int i = mapper.insertManyGoods(goods);
        System.out.println(i);
    }

    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] goodIds = {6,7};
        int i = mapper.deleteManyGoods(goodIds);
        System.out.println(i);
    }
}
