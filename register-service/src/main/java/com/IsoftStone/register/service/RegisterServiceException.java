package com.IsoftStone.register.service;

/**
 * Created by Bachelor Wang on 2014/5/25.
 */
public class RegisterServiceException extends Exception{
    public RegisterServiceException( String message )
    {
        super( message );
    }

    public RegisterServiceException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
