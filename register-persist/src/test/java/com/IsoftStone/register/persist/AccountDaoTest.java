package com.IsoftStone.register.persist;

import com.IsoftStone.register.dao.bo.RegisterAccountInf;
import com.IsoftStone.register.dao.dto.AccountDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Bachelor Wang on 2014/5/27.
 */
public class AccountDaoTest {
    private static SqlSessionFactory sqlSessionFactory = null;
    private RegisterAccountInf accountInf;
    @Before
    public void prepare() throws Exception{
        // MyBatis的主配置文件，这里采用相对类路径
        /*String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用默认environment元素创建SqlSessionFactory实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);*/
    }

    @Test
    public void testAccountDao()  throws Exception{
        /* mybatis Test...
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RegisterAccountInf accountInf = sqlSession.getMapper(RegisterAccountInf.class);
        Account account = new Account();

        account.setId("jing2");
        account.setName("第2靓仔");
        account.setEmail("wangyj0898@126.com");
        account.setPassword("123456");
        account.setActivated("true");
        accountInf.add(account);

        // 提交事务，否则不会添加到数据库
        sqlSession.commit();

        System.out.println("新增学生的ID： " + account.getPid());
        sqlSession.close();*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("register-persist.xml");
        accountInf = (RegisterAccountInf) ctx.getBean("accountMapper");
        AccountDTO account = new AccountDTO();
        account.setId("jing777");
        account.setName("第3靓仔");
        account.setEmail("rungen0898@yeah.com");
        account.setPassword("123456");
        account.setActivated("true");

        accountInf.add(account);
    }
}
