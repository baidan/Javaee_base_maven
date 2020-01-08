package com.baidan.service.impl;

import com.baidan.dao.IAccountDao;
import com.baidan.service.IAccountService;
import com.baidan.utils.BeanFactory;

public class AccountServiceImpl implements IAccountService {
    //private IAccountDao iAccountDao = new AccountDaoImpl();
    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    private static  int i = 1;

    @Override
    public void saveAccount() {
        System.out.println(i);
        iAccountDao.Save();
        i++;
    }
}
