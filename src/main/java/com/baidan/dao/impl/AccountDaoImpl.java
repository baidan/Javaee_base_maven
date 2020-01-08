package com.baidan.dao.impl;

import com.baidan.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void Save() {
        System.out.println("保存账户");
    }
}
