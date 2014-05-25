package com.IsoftStone.register.captcha;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bachelor Wang on 2014/5/24.
 */
public class RegisterCaptchaServiceTest {

    private RegisterCaptchaService service;

    @Before
    public void prepare() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("register-captcha.xml");
        service = (RegisterCaptchaService)ctx.getBean("registerCaptchaService");
    }

    @Test
    public void testGenerateCaptcha() throws Exception{
        String captchaKey = service.generateCaptchaKey();
        assertNotNull(captchaKey);

        byte[] catchaImage = service.generateCaptchaImage(captchaKey);
        assertTrue(catchaImage.length > 0);

        File image = new File("D:/JavaWorkSpace/register/register-captcha/target/" + captchaKey + ".jpg");
        OutputStream output = null;
        try{
            output = new FileOutputStream(image);
            output.write(catchaImage);
        }finally {
            if ( output != null )
            {
                output.close();
            }
        }
        assertTrue(image.exists() && image.length() > 0);
    }

    @Test
    public void testValidateCaptchaCorrect() throws Exception{

        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add("12345");
        preDefinedTexts.add("abcde");
        service.setPreDefinedTexts(preDefinedTexts);

        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        assertTrue(service.validateCaptcha(captchaKey,"12345"));

        captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage( captchaKey );
        assertTrue( service.validateCaptcha( captchaKey, "abcde" ) );
    }

    @Test
    public void testValidateCaptchaIncorrect() throws Exception{
        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add( "12345" );
        service.setPreDefinedTexts( preDefinedTexts );

        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage( captchaKey );
        assertFalse( service.validateCaptcha( captchaKey, "67890" ) );
    }
}
