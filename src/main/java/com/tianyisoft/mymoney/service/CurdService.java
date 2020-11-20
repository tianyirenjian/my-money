package com.tianyisoft.mymoney.service;

import java.util.List;

/**
 * @author tianyi
 * @param <T>
 */
public interface CurdService<T> {
    /**
     * 列表
     * @return 列表
     */
    List<T> list();

    /**
     * 新增
     * @param t object
     * @return 自增 id
     */
    int save(T t);

    /**
     * 获取
     * @param id id
     * @return object
     */
    T find(Integer id);

    /**
     * 更新
     * @param t object
     * @return 更新数量
     */
    int update(T t);

    /**
     * 删除
     * @param id id
     * @return 删除
     */
    int destroy(Integer id);
}
