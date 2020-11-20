package com.tianyisoft.mymoney.service.impl;

import com.tianyisoft.mymoney.dao.CurdMapper;
import com.tianyisoft.mymoney.entity.SystemTag;
import com.tianyisoft.mymoney.service.SystemTagService;
import org.springframework.stereotype.Service;


/**
 * @author tianyi
 */
@Service
public class SystemTagServiceImpl extends CurdServiceImpl<SystemTag> implements SystemTagService {

    public SystemTagServiceImpl(CurdMapper<SystemTag> mapper) {
        super(mapper);
    }
}
