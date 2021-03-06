package com.tianyisoft.mymoney.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tianyisoft.mymoney.dao.UserMapper;
import com.tianyisoft.mymoney.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tianyi
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private Algorithm hmac256;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");
        String tokenPrefix = "Bearer ";
        if (token == null || !token.startsWith(tokenPrefix)) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "未登录!");
        }
        token = token.replaceFirst(tokenPrefix, "");
        JWTVerifier verifier = JWT.require(hmac256).build();
        try {
            DecodedJWT decodedJwt = verifier.verify(token);
            Integer uid = decodedJwt.getClaim("uid").asInt();
            User user = userMapper.getById(uid);
            if (uid == null) {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "用户不存在!");
            }
            request.setAttribute("user", user);
        } catch (JWTVerificationException exception) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "未登录!");
        }
        return true;
    }
}
