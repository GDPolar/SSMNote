package com.xd.pl.dao.impl;

import com.xd.pl.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("save kanryo");
    }
}
