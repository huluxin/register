package com.IsoftStone.register.captcha;

/**
 * Created by Bachelor Wang on 2014/5/23.
 */
public class RegisterCaptchaException extends Exception{
    private static final long serialVersionUID = 1339439433313285858L;

    public RegisterCaptchaException( String message )
    {
        super( message );
    }

    public RegisterCaptchaException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
