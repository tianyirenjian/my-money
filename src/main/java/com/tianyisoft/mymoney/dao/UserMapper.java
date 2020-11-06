package com.tianyisoft.mymoney.dao;

import com.tianyisoft.mymoney.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author tianyi
 */
@Repository
public interface UserMapper {
    /**
     * find user by name
     * @param name name
     * @return User
     */
    public User getByName(String name);

    /**
     * get user by id
     * @param id id
     * @return User
     */
    User getById(Integer id);
}
