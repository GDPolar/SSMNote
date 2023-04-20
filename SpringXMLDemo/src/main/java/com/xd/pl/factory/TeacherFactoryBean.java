package com.xd.pl.factory;

import com.xd.pl.pojo.Teacher;
import org.springframework.beans.factory.FactoryBean;

// 实现 FactoryBean<?> 接口
public class TeacherFactoryBean implements FactoryBean<Teacher> {

    @Override
    public Teacher getObject() throws Exception {
        return new Teacher();
    }

    @Override
    public Class<?> getObjectType() {
        return Teacher.class;
    }
}
