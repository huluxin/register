package com.IsoftStone.register.service.dao.bo;

import com.IsoftStone.register.service.SignUpRequest;

/**
 * Created by Bachelor Wang on 2014/6/6.
 */
public interface RegisterAccountService {

    void addAccount(SignUpRequest signUpRequest) throws Exception;
}
