package com.tianyisoft.mymoney.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tianyi
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private Boolean enable;
    private Boolean admin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
