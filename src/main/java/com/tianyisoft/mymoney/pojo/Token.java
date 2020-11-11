package com.tianyisoft.mymoney.pojo;

import lombok.Data;

/**
 * @author tianyi
 */
@Data
public class Token {
    private String token;
    private String expire;
    private String tokenType = "Bearer";
}
