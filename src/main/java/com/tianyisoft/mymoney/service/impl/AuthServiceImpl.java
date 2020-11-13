package com.tianyisoft.mymoney.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tianyisoft.mymoney.dao.UserMapper;
import com.tianyisoft.mymoney.entity.User;
import com.tianyisoft.mymoney.pojo.Token;
import com.tianyisoft.mymoney.pojo.UserPojo;
import com.tianyisoft.mymoney.service.AuthService;
import com.tianyisoft.mymoney.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author tianyi
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final Algorithm hmac256;

    public AuthServiceImpl(UserMapper userMapper, Algorithm hmac256) {
        this.userMapper = userMapper;
        this.hmac256 = hmac256;
    }

    @Override
    public Token authorize(UserPojo user) {
        User u = userMapper.getByName(user.getName());
        if (u == null || !BCrypt.verifyer().verify(user.getPassword().toCharArray(), u.getPassword().toCharArray()).verified) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "用户名或密码错误！");
        }
        if (!u.getEnable()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "用户已被禁用！");
        }
        String token = JWT.create()
                .withExpiresAt(DateUtils.nowAddYear(1))
                .withClaim("uid", u.getId())
                .sign(hmac256);
        Token tk = new Token();
        tk.setToken(token);
        tk.setExpire(DateUtils.nowAddYearString(1));
        return tk;
    }
}
