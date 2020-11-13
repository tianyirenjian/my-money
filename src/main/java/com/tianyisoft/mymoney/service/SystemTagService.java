package com.tianyisoft.mymoney.service;

import com.tianyisoft.mymoney.entity.SystemTag;

import java.util.List;

/**
 * @author tianyi
 */
public interface SystemTagService {
    /**
     * 标签列表
     * @return 标签列表
     */
    List<SystemTag> list();

    /**
     * 新增标签
     * @param tag object
     * @return 自增 id
     */
    int save(SystemTag tag);

    /**
     * 获取标签
     * @param id 标签 id
     * @return 标签
     */
    SystemTag find(Integer id);

    /**
     * 更新标签
     * @param tag object
     * @return 更新数量
     */
    int update(SystemTag tag);

    /**
     * 删除标签
     * @param id 标签 id
     * @return 删除数量
     */
    int destroy(Integer id);
}
