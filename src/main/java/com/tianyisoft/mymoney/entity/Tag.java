package com.tianyisoft.mymoney.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author tianyi
 */
@Data
public class Tag {
    private Integer id;
    @NotEmpty(message = "名称不能为空")
    private String name;
}
