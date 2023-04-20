package com.xd.pl.mapper;

import com.xd.pl.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.IORInterceptor;

import java.util.List;

public interface EmpMapper {
    Emp selectEmpById(@Param("empId") Integer id);

    Emp selectEmpById2(Integer id);

    Emp selectEmpById3(int id);

    Emp getEmpAndDeptByStep(int id);

    List<Emp> getEmpByDeptId(int id);
}
