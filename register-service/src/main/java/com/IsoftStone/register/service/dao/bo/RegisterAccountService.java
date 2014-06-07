package com.IsoftStone.register.service.dao.bo;

import com.IsoftStone.register.service.SignUpRequest;

/**
 * Created by Bachelor Wang on 2014/6/6.
 */
public interface RegisterAccountService {

    public void addAccount(SignUpRequest signUpRequest) throws Exception;

    public void updateAccount(SignUpRequest signUpRequest) throws Exception;

    public void deleteAccount(long id);
}
