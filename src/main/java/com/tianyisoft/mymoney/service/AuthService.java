package com.tianyisoft.mymoney.service;

import com.tianyisoft.mymoney.pojo.Token;
import com.tianyisoft.mymoney.pojo.UserPojo;

/**
 * @author tianyi
 */
public interface AuthService {
    /**
     * 用户登录，获取 token
     * @param user
     * @return token object
     */
    public Token authorize(UserPojo user);
}
