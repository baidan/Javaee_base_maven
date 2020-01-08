package com.baidan.controller;

import com.baidan.service.IAccountService;
import com.baidan.utils.BeanFactory;
import org.junit.Test;

public class AccoutServlet extends BaseServlet {
    //private IAccountService IAccountService = new AccountServiceImpl();
    //private IAccountService IAccountService = (IAccountService) BeanFactory.getBean("accountService");

    @Test
    public void accoutController() {
        for (int i = 0; i < 5; i++) {
            IAccountService IAccountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(IAccountService);
            //IAccountService.saveAccount();
        }
    }


}
