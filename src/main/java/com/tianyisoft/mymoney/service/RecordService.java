package com.tianyisoft.mymoney.service;

import com.tianyisoft.mymoney.entity.Record;
import com.tianyisoft.mymoney.pojo.Pager;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tianyi
 */
public interface RecordService extends CurdService<Record> {
    /**
     * 分页
     * @param request request
     * @return pager
     */
    default Pager paginate(HttpServletRequest request) {
        return this.paginate(request, null);
    }


    /**
     * 分页
     * @param request request
     * @param userId user id
     * @return pager
     */
    Pager paginate(HttpServletRequest request, Integer userId);
}
