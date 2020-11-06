package com.tianyisoft.mymoney.service;

import com.tianyisoft.mymoney.entity.User;

/**
 * @author tianyi
 */
public interface UserService {
    /**
     * get user by name
     * @param name name
     * @return User
     */
    public User getByName(String name);

    /**
     * get user by id
     * @param id id
     * @return User
     */
    public User getById(Integer id);
}
