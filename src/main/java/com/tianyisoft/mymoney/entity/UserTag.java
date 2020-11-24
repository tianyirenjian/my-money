package com.tianyisoft.mymoney.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @author tianyi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserTag extends Tag {
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
