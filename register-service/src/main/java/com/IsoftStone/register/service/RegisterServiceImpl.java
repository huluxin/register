package com.IsoftStone.register.service;

import com.IsoftStone.register.captcha.RandomGenerator;
import com.IsoftStone.register.captcha.RegisterCaptchaException;
import com.IsoftStone.register.captcha.RegisterCaptchaService;
import com.IsoftStone.register.email.RegisterEmailException;
import com.IsoftStone.register.email.RegisterEmailService;
import com.IsoftStone.register.persist.Account;
import com.IsoftStone.register.persist.AccountPersistException;
import com.IsoftStone.register.persist.AccountPersistService;

import java.util.HashMap;
import java.util.Map;

/**
 * 用来封装底层三个模块的细节
 * Created by Bachelor Wang on 2014/5/25.
 */
public class RegisterServiceImpl implements RegisterService {

    private AccountPersistService accountPersistService;
    private RegisterEmailService registerEmailService;
    private RegisterCaptchaService registerCaptchaService;

    private Map<String, String> activationMap = new HashMap<String, String>();

    @Override
    public String generateCaptchaKey() throws RegisterServiceException {

        try {
            return registerCaptchaService.generateCaptchaKey();
        } catch (RegisterCaptchaException e) {
            throw new RegisterServiceException("Unable to generate Captcha Image.", e);
        }
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws RegisterServiceException {

        try {
            return registerCaptchaService.generateCaptchaImage(captchaKey);
        } catch (RegisterCaptchaException e) {
            throw new RegisterServiceException("Unable to generate Captcha Image.", e);
        }
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) throws RegisterServiceException {

        try {
            if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
                throw new RegisterServiceException("2 passwords do not match.");
            }

            if (!registerCaptchaService.validateCaptcha(signUpRequest.getCaptchaKey(), signUpRequest.getCaptchaValue())) {
                throw new RegisterServiceException("Incorrect Captcha.");
            }

            Account account = new Account();
            account.setId(signUpRequest.getId());
            account.setEmail(signUpRequest.getEmail());
            account.setName(signUpRequest.getName());
            account.setPassword(signUpRequest.getPassword());
            account.setActivated(false);

            accountPersistService.createAccount(account);

            String activationId = RandomGenerator.getRandomString();
            activationMap.put(activationId, account.getId());

            String link = signUpRequest.getActivateServiceUrl().endsWith("/") ? signUpRequest.getActivateServiceUrl()
                    + activationId : signUpRequest.getActivateServiceUrl() + "?key=" + activationId;

            registerEmailService.sendMail(account.getEmail(), "Please Activate Your Account", link);
        } catch (RegisterCaptchaException e) {
            throw new RegisterServiceException("Unable to validate captcha.", e);
        } catch (AccountPersistException e) {
            throw new RegisterServiceException("Unable to create account.", e);
        } catch (RegisterEmailException e) {
            throw new RegisterServiceException("Unable to send actiavtion mail.", e);
        }
    }

    @Override
    public void activate(String activationId) throws RegisterServiceException {

        String accountId = activationMap.get(activationId);
        if (accountId == null) {
            throw new RegisterServiceException("Invalid account activation ID.");
        }

        try {
            Account account = accountPersistService.readAccount(accountId);
            account.setActivated(true);
            accountPersistService.updateAccount(account);
        } catch (AccountPersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void login(String id, String password) throws RegisterServiceException {

        try {
            Account account = accountPersistService.readAccount(id);

            if (account == null) {
                throw new RegisterServiceException("Account does not exist.");
            }

            if (!account.isActivated()) {
                throw new RegisterServiceException("Account is disabled.");
            }

            if (!account.getPassword().equals(password)) {
                throw new RegisterServiceException("Incorrect password.");
            }
        } catch (AccountPersistException e) {
            throw new RegisterServiceException("Unable to log in.", e);
        }
    }

    public AccountPersistService getAccountPersistService() {
        return accountPersistService;
    }

    public void setAccountPersistService(AccountPersistService accountPersistService) {
        this.accountPersistService = accountPersistService;
    }

    public RegisterEmailService getRegisterEmailService() {
        return registerEmailService;
    }

    public void setRegisterEmailService(RegisterEmailService registerEmailService) {
        this.registerEmailService = registerEmailService;
    }

    public RegisterCaptchaService getRegisterCaptchaService() {
        return registerCaptchaService;
    }

    public void setRegisterCaptchaService(RegisterCaptchaService registerCaptchaService) {
        this.registerCaptchaService = registerCaptchaService;
    }
}
