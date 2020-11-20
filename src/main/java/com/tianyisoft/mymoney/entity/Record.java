package com.tianyisoft.mymoney.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tianyi
 */
@Data
public class Record {
    private Integer id;
    private Integer tagId;
    private String tagType;
    private Integer userId;
    private Boolean out;
    private Integer money;
    private Integer bookId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Tag tag;
}
