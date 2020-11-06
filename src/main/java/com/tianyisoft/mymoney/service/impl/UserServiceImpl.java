package com.tianyisoft.mymoney.service.impl;

import com.tianyisoft.mymoney.dao.UserMapper;
import com.tianyisoft.mymoney.entity.User;
import com.tianyisoft.mymoney.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author tianyi
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }
}
