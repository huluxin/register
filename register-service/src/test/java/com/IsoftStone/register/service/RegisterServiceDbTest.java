package com.IsoftStone.register.service;

import com.IsoftStone.register.service.dao.bo.RegisterAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Bachelor Wang on 2014/6/6.
 */
public class RegisterServiceDbTest {

    private RegisterAccountService registerAccountService;

    @Test
    public void testRegisterDbService(){
        try {
            String[] springConfigFiles = {
                    "register-email.xml",
                    "register-persist.xml",
                    "register-captcha.xml",
                    "register-service.xml" };

          //  ApplicationContext ctx = new ClassPathXmlApplicationContext( springConfigFiles );

            ApplicationContext ctx = new ClassPathXmlApplicationContext("register-service.xml");
            registerAccountService = (RegisterAccountService) ctx.getBean("registerAccountService");
            // 2. Submit sign up Request
            SignUpRequest signUpRequest = new SignUpRequest();
            //   signUpRequest.setCaptchaKey( captchaKey );
            //   signUpRequest.setCaptchaValue( captchaValue );
            signUpRequest.setId( "YeahGod" );
            signUpRequest.setEmail( "rungen0898@Yeah.com" );
            signUpRequest.setName( "Jingy wang" );
            signUpRequest.setPassword( "Yeah_Root02" );
            signUpRequest.setConfirmPassword( "Yeah_Root02" );
            signUpRequest.setActivateServiceUrl( "http://localhost:8080/register/activate" );

            registerAccountService.addAccount(signUpRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
