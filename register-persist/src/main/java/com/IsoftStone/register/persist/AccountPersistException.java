package com.IsoftStone.register.persist;

/**
 * Created by Bachelor Wang on 2014/5/24.
 */
public class AccountPersistException extends Exception{

    public AccountPersistException( String message )
    {
        super( message );
    }

    public AccountPersistException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
