package com.tianyisoft.mymoney.service.impl;

import com.tianyisoft.mymoney.dao.SystemTagMapper;
import com.tianyisoft.mymoney.entity.SystemTag;
import com.tianyisoft.mymoney.service.SystemTagService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * @author tianyi
 */
@Service
public class SystemTagServiceImpl implements SystemTagService {
    private final SystemTagMapper tagMapper;

    public SystemTagServiceImpl(SystemTagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public List<SystemTag> list() {
        return tagMapper.list();
    }

    @Override
    public int save(SystemTag tag) {
        return tagMapper.save(tag);
    }

    @Override
    public SystemTag find(Integer id) {
        SystemTag tag = tagMapper.find(id);
        if (tag == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "标签不存在");
        }
        return tag;
    }

    @Override
    public int update(SystemTag tag) {
        return tagMapper.update(tag);
    }

    @Override
    public int destroy(Integer id) {
        return tagMapper.destroy(id);
    }
}
