package com.tianyisoft.mymoney.entity;

import com.tianyisoft.mymoney.annotation.NoDatetime;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


/**
 * @author tianyi
 */
@Data
@NoDatetime
public class SystemTag implements Tag {
    private Integer id;
    @NotEmpty(message = "名称不能为空")
    private String name;
}
