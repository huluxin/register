package com.IsoftStone.register.service;

/**
 * Created by Bachelor Wang on 2014/5/25.
 */
public interface RegisterService {

    String generateCaptchaKey() throws RegisterServiceException;

    byte[] generateCaptchaImage(String captchaKey) throws RegisterServiceException;

    void signUp(SignUpRequest signUpRequest) throws RegisterServiceException;

    void activate(String activationNumber) throws RegisterServiceException;

    void login(String id ,String password) throws RegisterServiceException;
}
