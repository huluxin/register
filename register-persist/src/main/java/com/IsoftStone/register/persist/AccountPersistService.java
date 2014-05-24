package com.IsoftStone.register.persist;

/**
 * 接口，其方法对应了账户的，增删改查
 * Created by Bachelor Wang on 2014/5/24.
 */
public interface AccountPersistService {

    Account createAccount(Account account) throws AccountPersistException;

    Account readAccount(String id) throws AccountPersistException;

    Account updateAccount(Account account) throws AccountPersistException;

    void deleteAccount(String id) throws AccountPersistException;
}
