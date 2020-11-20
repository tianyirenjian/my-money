package com.tianyisoft.mymoney.pojo;

import lombok.Data;
import org.apache.catalina.util.ParameterMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tianyi
 */
@Data
public class Pager {
    private List<?> data;
    private Integer page;
    private Integer pageSize;
    private Integer total;
    private String prev;
    private String next;

    public Pager() {}

    public Pager(HttpServletRequest request, List<?> data, Integer total, Integer page, Integer pageSize) {
        this.data = data;
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
        make(request);
    }

    public void make(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        Map<String, String[]> map = request.getParameterMap();
        ((ParameterMap<String,String[]>) map).setLocked(false);

        if (hasNextPage()) {
            map.put("page", new String[]{Integer.toString(page + 1)});
            next = url + "?" + map.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()[0]).collect(Collectors.joining("&"));
        }
        if (page > 1) {
            map.put("page", new String[]{Integer.toString(page - 1)});
            prev = url + "?" + map.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()[0]).collect(Collectors.joining("&"));
        }
    }

    private Boolean hasNextPage() {
        return Math.floorDiv(total, pageSize) > page;
    }
}
