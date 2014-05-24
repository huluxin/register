package com.IsoftStone.register.email;

/**
 * Created by Bachelor Wang on 2014/5/22.
 */
public class RegisterEmailException extends Exception{
    public RegisterEmailException( String message )
    {
        super( message );
    }

    public RegisterEmailException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
