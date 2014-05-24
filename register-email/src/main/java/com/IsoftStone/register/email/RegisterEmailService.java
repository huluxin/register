package com.IsoftStone.register.email;

/**
 * Created by Bachelor Wang on 2014/5/22.
 */
public interface RegisterEmailService {
    void sendMail( String to, String subject, String htmlText )
            throws RegisterEmailException;
}
