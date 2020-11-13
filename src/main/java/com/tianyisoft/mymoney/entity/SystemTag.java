package com.tianyisoft.mymoney.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class SystemTag {
    private Integer id;
    @NotEmpty(message = "名称不能为空")
    private String name;
}
