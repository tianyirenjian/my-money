package com.tianyisoft.mymoney.service.impl;

import com.tianyisoft.mymoney.dao.RecordMapper;
import com.tianyisoft.mymoney.entity.Record;
import com.tianyisoft.mymoney.pojo.Pager;
import com.tianyisoft.mymoney.service.RecordService;
import com.tianyisoft.mymoney.util.Utils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianyi
 */
@Service
public class RecordServiceImpl extends CurdServiceImpl<Record> implements RecordService {
    private final RecordMapper mapper;

    public RecordServiceImpl(RecordMapper mapper) {
        super(mapper);
        this.mapper = mapper;
    }

    @Override
    public Pager paginate(HttpServletRequest request, Integer userId) {
        Integer page = Utils.parseIntDefault(request.getParameter("page"), 1);
        Integer pageSize = Utils.parseIntDefault(request.getParameter("page_size"), 10);
        List<Record> records = mapper.paginate((page - 1) * pageSize, pageSize ,userId, "id");
        Map<String, Object> map = new HashMap<>(1);
        Map<String, Object> condition = new HashMap<>(1);
        condition.put("user_id", userId);
        map.put("map", condition);
        Integer total = mapper.count(map);

        return new Pager(request, records, total, page, pageSize);
    }
}
