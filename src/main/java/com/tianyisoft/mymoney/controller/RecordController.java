package com.tianyisoft.mymoney.controller;

import com.tianyisoft.mymoney.entity.Record;
import com.tianyisoft.mymoney.pojo.Pager;
import com.tianyisoft.mymoney.service.RecordService;
import com.tianyisoft.mymoney.util.Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tianyi
 */
@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @GetMapping("")
    public Pager paginate(HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        return service.paginate(request, (Integer) Utils.getFieldValueFromObject(request.getAttribute("user"), "id"));
    }

    @PostMapping("")
    public Record save(@RequestBody Record record, HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        Object user = request.getAttribute("user");
        record.setUserId((Integer) Utils.getFieldValueFromObject(user, "id"));
        service.save(record);
        return service.find(record.getId());
    }
}
