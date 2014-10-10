package com.IsoftStone.register.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bachelor Wang on 2014/5/22.
 */
public class RegisterEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void startMailServer() throws Exception{
      //  greenMail = new GreenMail( ServerSetup.SMTP );
      //  greenMail.setUser("test@yeah.com","123456");
      //  greenMail.start();
    }

    @Test
    public void testSendMail() throws Exception{
        /*ApplicationContext ctx = new ClassPathXmlApplicationContext( "register-email.xml" );
        RegisterEmailService accountEmailService = (RegisterEmailService) ctx.getBean( "registerEmailService" );

        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail( "wangyj0898@126.com", subject, htmlText );

        greenMail.waitForIncomingEmail(2000,1);

        Message[] msgs = greenMail.getReceivedMessages();
        assertEquals(1, msgs.length);
        assertEquals("admin@yeah.com",msgs[0].getFrom()[0].toString());
        assertEquals( subject, msgs[0].getSubject() );
        assertEquals( htmlText, GreenMailUtil.getBody(msgs[0]).trim() );*/
    }

    @After
    public void stopMailServer()
            throws Exception
{
        //  greenMail.stop();
        }
        }
