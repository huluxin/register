package com.IsoftStone.baobaotao.dao;

import com.IsoftStone.baobaotao.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2014/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class) //基于Junit4 的Spring 测试框架
@ContextConfiguration(locations = {"/register-spring.xml"})  //启动Spring容器
public class TestUserDao {

    @Autowired
    private UserDao userDao;
    @Test
    public void testAccountDao()  throws Exception{
        User user = new User();
        user.setUserid(1);
        user.setLastIp("localhost");
        userDao.updateLoginInfo(user);
    }
}
