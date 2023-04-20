package com.xd.pl.mapper;

import com.xd.pl.pojo.Dept;

public interface DeptMapper {
    Dept getDeptById(int id);

    Dept getDeptAndEmpsById(int id);

    Dept getDeptAndEmpsByStep(int id);
}
