package com.xd.pl.service.impl;

import com.xd.pl.service.HiService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HiServiceImpl implements HiService {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
}
