package com.IsoftStone.register.captcha;

import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * Created by Bachelor Wang on 2014/5/23.
 */
public class RegisterCaptchaServiceImpl implements RegisterCaptchaService,InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public String generateCaptchaKey() throws RegisterCaptchaException {
        return null;
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws RegisterCaptchaException {
        return new byte[0];
    }

    @Override
    public boolean validateCaptcha(String captchaKey, String captchaValue) throws RegisterCaptchaException {
        return false;
    }

    @Override
    public List<String> getPreDefinedTexts() {
        return null;
    }

    @Override
    public void setPreDefinedTexts(List<String> preDefinedTexts) {

    }
}
