package com.tianyisoft.mymoney.dao;

import com.tianyisoft.mymoney.entity.UserTag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianyi
 */
@Repository
public interface UserTagMapper {
    /**
     * 用户标签列表
     * @return user tag
     */
    @Select("select * from user_tag")
    List<UserTag> list();

    /**
     * 添加用户标签
     * @param userTag object
     * @return 添加条数
     */
    @Insert("insert into user_tag (name, user_id, created_at, updated_at) values (#{name}, #{userId}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int save(UserTag userTag);

    /**
     * 获取用户标签
     * @param id id
     * @return user tag
     */
    @Select("select * from user_tag where id = #{id}")
    UserTag find(Integer id);

    /**
     * 更新用户标签
     * @param userTag object
     * @return 修改行数
     */
    @Update("update user_tag set name = #{name}, updated_at = #{updatedAt} where id = #{id}")
    int update(UserTag userTag);

    /**
     * 删除用户标签
     * @param id id
     * @return 删除条数
     */
    @Delete("delete from user_tag where id = #{id}")
    int destroy(Integer id);
}
