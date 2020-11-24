package com.tianyisoft.mymoney.dao;

import com.tianyisoft.mymoney.entity.Record;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author tianyi
 */
@Repository
public interface RecordMapper extends CurdMapper<Record> {
    /**
     * {@inheritDoc}
     * @param offset offset
     * @param limit page size
     * @param sortBy sort by
     * @return
     */
    @Override
    default List<Record> paginate(Integer offset, Integer limit, String sortBy) {
        return this.paginate(offset, limit, null, sortBy);
    }

    /**
     * 分页
     * @param offset offset
     * @param limit limit
     * @param userId user id
     * @param sortBy sort by
     * @return 列表
     */
    List<Record> paginate(Integer offset, Integer limit, Integer userId, String sortBy);

    /**
     * {@inheritDoc}
     * @param id id
     * @return
     */
    @Override
    @Delete("delete from record where id = #{id}")
    int destroy(Integer id);
}
