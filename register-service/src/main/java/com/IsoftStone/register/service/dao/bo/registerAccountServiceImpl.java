package com.IsoftStone.register.service.dao.bo;

import com.IsoftStone.register.dao.bo.RegisterAccountInf;
import com.IsoftStone.register.dao.dto.AccountDTO;
import com.IsoftStone.register.service.SignUpRequest;

/**
 * Created by Bachelor Wang on 2014/6/6.
 */
public class RegisterAccountServiceImpl implements RegisterAccountService {

  //  private RegisterAccountInf registerAccountPersist ;

    public RegisterAccountInf getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(RegisterAccountInf accountMapper) {
        this.accountMapper = accountMapper;
    }

    private RegisterAccountInf accountMapper;

/*    public RegisterAccountInf getRegisterAccountPersist() {
        return registerAccountPersist;
    }

    public void setRegisterAccountPersist(RegisterAccountInf registerAccountPersist) {
        this.registerAccountPersist = registerAccountPersist;
    }*/

    @Override
    public void addAccount(SignUpRequest signUpRequest) throws Exception {

        AccountDTO account = new AccountDTO();
        account.setId(signUpRequest.getId());
        account.setEmail(signUpRequest.getEmail());
        account.setName(signUpRequest.getName());
        account.setPassword(signUpRequest.getPassword());
        account.setActivated("false");

        accountMapper.add(account);
    }

    @Override
    public void updateAccount(SignUpRequest signUpRequest) throws Exception {

    }

    @Override
    public void deleteAccount(long id) {

    }

}
