package com.tianyisoft.mymoney.dao;

import java.util.List;
import java.util.Map;

/**
 * @author tianyi
 * @param <E>
 */
public interface CurdMapper<E> {
    /**
     * 列表
     * @return 列表
     */
    List<E> list();

    /**
     * 分页
     * @param offset offset
     * @param limit page size
     * @param sortBy sort by
     * @return 列表
     */
    List<E> paginate(Integer offset, Integer limit, String sortBy);

    /**
     * 获取数量
     * @param condition key value
     * @return count
     */
    Integer count(Map<String, Object> condition);

    /**
     * 添加
     * @param e e
     * @return 保存条数
     */
    int save(E e);

    /**
     * 详情
     * @param id id
     * @return e
     */
    E find(Integer id);

    /**
     * 更新
     * @param e e
     * @return 更新条数
     */
    int update(E e);

    /**
     * 删除
     * @param id id
     * @return 删除条数
     */
    int destroy(Integer id);
}
