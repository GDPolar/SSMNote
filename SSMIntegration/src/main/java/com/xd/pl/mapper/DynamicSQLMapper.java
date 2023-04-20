package com.xd.pl.mapper;

import com.xd.pl.pojo.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    List<Good> getGoodByCondition1(Good good);

    List<Good> getGoodByCondition2(Good good);

    List<Good> getGoodByCondition3(Good good);

    List<Good> getGoodByCondition4(Good good);

    int insertManyGoods(@Param("goods") List<Good> goods);

    int deleteManyGoods(@Param("goodIds") Integer[] goods);
}
