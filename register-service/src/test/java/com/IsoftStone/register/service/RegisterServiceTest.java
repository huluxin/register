package com.IsoftStone.register.service;

import com.IsoftStone.register.captcha.RegisterCaptchaService;
import com.IsoftStone.register.persist.AccountPersistService;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Bachelor Wang on 2014/5/25.
 */
public class RegisterServiceTest {

    private GreenMail greenMail;
    private RegisterService registerService;

    @Before
    public void prepare() throws Exception{
        String[] springConfigFiles = {
                "register-email.xml",
                "register-persist.xml",
                "register-captcha.xml",
                "register-service.xml" };

        ApplicationContext ctx = new ClassPathXmlApplicationContext( springConfigFiles );

        RegisterCaptchaService registerCaptchaService = (RegisterCaptchaService) ctx.getBean("registerCaptchaService");

        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add( "12345" );
        preDefinedTexts.add( "abcde" );
        registerCaptchaService.setPreDefinedTexts( preDefinedTexts );

        registerService = (RegisterService) ctx.getBean("registerService");

        greenMail = new GreenMail( ServerSetup.SMTP );
        greenMail.setUser( "test@juvenxu.com", "123456" );
        greenMail.start();

        File persistDataFile =  new File("target/test-classes/persist-data.xml");

        if ( persistDataFile.exists() )
        {
            persistDataFile.delete();
        }
    }

    @Test
    public void testRegisterService() throws Exception{

        // 1. Get captcha
        String captchaKey = registerService.generateCaptchaKey();
        registerService.generateCaptchaImage( captchaKey );
        String captchaValue = "12345";

        // 2. Submit sign up Request
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setCaptchaKey( captchaKey );
        signUpRequest.setCaptchaValue( captchaValue );
        signUpRequest.setId( "jing2" );
        signUpRequest.setEmail( "wangyj0898@126.com" );
        signUpRequest.setName( "Jingy wang" );
        signUpRequest.setPassword( "admin" );
        signUpRequest.setConfirmPassword( "admin" );
        signUpRequest.setActivateServiceUrl( "http://localhost:8080/register/activate" );
        registerService.signUp( signUpRequest );

        /**
         * 3. Read activation link
         */
        greenMail.waitForIncomingEmail( 2000, 1 );
        Message[] msgs = greenMail.getReceivedMessages();
        assertEquals( 1, msgs.length );
        assertEquals( "Please Activate Your Account", msgs[0].getSubject() );
        String activationLink = GreenMailUtil.getBody( msgs[0] ).trim();

        // 3a. Try login but not activated
        try
        {
            registerService.login( "jing2", "admin" );
            fail( "Disabled account shouldn't be able to log in." );
        }
        catch ( RegisterServiceException e ){}

        // 4. Activate account
        String activationCode = activationLink.substring( activationLink.lastIndexOf( "=" ) + 1 );
        registerService.activate( activationCode );

        // 5. Login with correct id and password
        registerService.login( "jing2", "admin" );

        // 5a. Login with incorrect password
        try{
            registerService.login("jing2","root");
            fail( "Password is incorrect, shouldn't be able to login." );
        }catch (RegisterServiceException e){}
    }

    @After
    public void stopMailServer()throws Exception{
        greenMail.stop();
    }
}
