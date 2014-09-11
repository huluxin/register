package com.IsoftStone.baobaotao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2014/9/11.
 */
@RunWith(SpringJUnit4ClassRunner.class) //基于Junit4 的Spring 测试框架
@ContextConfiguration(locations = {"/register-spring.xml"})  //启动Spring容器
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void hashMatchUser(){
        boolean b1 = userService.hashMatchUser("admin","123456");
       // boolean b2 = userService.hashMatchUser("admin","1111");
        assertTrue(b1);
      //  assertTrue(!b2);
    }

}
