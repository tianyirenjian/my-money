package com.tianyisoft.mymoney.dao;

import com.tianyisoft.mymoney.entity.SystemTag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianyi
 */
@Repository
public interface SystemTagMapper extends CurdMapper<SystemTag> {
    /**
     * 获取所有系统标签
     * @return system tag list
     */
    @Override
    @Select("SELECT * FROM system_tag")
    List<SystemTag> list();

    /**
     * 添加系统标签
     * @param tag object
     * @return 添加条数
     */
    @Override
    @Insert("INSERT INTO system_tag (name) values (#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int save(SystemTag tag);

    /**
     * 获取系统标签
     * @param id 标签 id
     * @return 标签
     */
    @Override
    @Select("SELECT * FROM system_tag WHERE id = #{id}")
    SystemTag find(Integer id);

    /**
     * 更新系统标签
     * @param tag object
     * @return 修改数量
     */
    @Override
    @Update("UPDATE system_tag SET name = #{name} WHERE id = #{id}")
    int update(SystemTag tag);

    /**
     * 删除系统标签
     * @param id 标签 id
     * @return 删除数量
     */
    @Override
    @Delete("DELETE FROM system_tag WHERE id = #{id}")
    int destroy(Integer id);
}
