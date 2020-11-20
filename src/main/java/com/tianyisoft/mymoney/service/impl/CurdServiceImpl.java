package com.tianyisoft.mymoney.service.impl;

import com.tianyisoft.mymoney.dao.CurdMapper;
import com.tianyisoft.mymoney.service.CurdService;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * @author tianyi
 * @param <T>
 */
public class CurdServiceImpl<T> implements CurdService<T> {
    private final CurdMapper<T> mapper;

    public CurdServiceImpl(CurdMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> list() {
        return mapper.list();
    }

    @Override
    public int save(T t) {
        return mapper.save(t);
    }

    @Override
    public T find(Integer id) {
        T t = mapper.find(id);
        if (t == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "对象不存在");
        }
        return t;
    }

    @Override
    public int update(T t) {
        return mapper.update(t);
    }

    @Override
    public int destroy(Integer id) {
        return mapper.destroy(id);
    }
}
