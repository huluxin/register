package com.IsoftStone.register.captcha;

import java.util.List;

/**
 * Created by Bachelor Wang on 2014/5/23.
 */
public interface RegisterCaptchaService {
    String generateCaptchaKey()
            throws  RegisterCaptchaException;

    byte[] generateCaptchaImage( String captchaKey )
            throws  RegisterCaptchaException;

    boolean validateCaptcha( String captchaKey, String captchaValue )
            throws  RegisterCaptchaException;

    List<String> getPreDefinedTexts();

    void setPreDefinedTexts( List<String> preDefinedTexts );
}
