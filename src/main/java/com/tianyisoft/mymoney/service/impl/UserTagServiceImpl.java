package com.tianyisoft.mymoney.service.impl;

import com.tianyisoft.mymoney.dao.CurdMapper;
import com.tianyisoft.mymoney.entity.UserTag;
import com.tianyisoft.mymoney.service.UserTagService;
import org.springframework.stereotype.Service;

/**
 * @author tianyi
 */
@Service
public class UserTagServiceImpl extends CurdServiceImpl<UserTag> implements UserTagService {
    public UserTagServiceImpl(CurdMapper<UserTag> mapper) {
        super(mapper);
    }
}
