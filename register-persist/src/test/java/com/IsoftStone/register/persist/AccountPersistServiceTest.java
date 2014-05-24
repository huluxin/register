package com.IsoftStone.register.persist;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bachelor Wang on 2014/5/24.
 */
public class AccountPersistServiceTest {
    private AccountPersistService service;

    @Before
    public void prepare() throws Exception{

        File persistDataFile = new File("target/test-classes/persist-data.xml");
        if(persistDataFile.exists() ){
            persistDataFile.delete();
        }
        ApplicationContext ctx = new ClassPathXmlApplicationContext("register-persist.xml");

        service = (AccountPersistService)ctx.getBean("accountPersistService");
        Account account = new Account();
        account.setId("jing");
        account.setName("Jingy wang");
        account.setEmail("wangyj0898@126.com");
        account.setPassword("this_should_be_encrypted");
        account.setActivated(true);

        service.createAccount(account);
    }

    @Test
    public void testReadAccount()  throws Exception{
        Account account = service.readAccount("jing");

        assertNotNull(account);
        assertEquals("jing",account.getId());
        assertEquals("Jingy wang",account.getName());
        assertEquals("wangyj0898@126.com",account.getEmail());
        assertEquals("this_should_be_encrypted",account.getPassword());
        assertTrue(account.isActivated());
    }
}
