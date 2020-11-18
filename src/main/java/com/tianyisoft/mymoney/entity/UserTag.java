package com.tianyisoft.mymoney.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @author tianyi
 */
@Data
public class UserTag {
    private Integer id;
    @NotEmpty(message = "名称不能为空")
    private String name;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
