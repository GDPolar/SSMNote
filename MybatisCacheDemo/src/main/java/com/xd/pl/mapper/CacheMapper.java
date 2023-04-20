package com.xd.pl.mapper;

import com.xd.pl.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    Emp getEmpById(@Param("empId") int id);
}
