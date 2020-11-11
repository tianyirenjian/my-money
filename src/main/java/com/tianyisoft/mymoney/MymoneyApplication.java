package com.tianyisoft.mymoney;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tianyi
 */
@SpringBootApplication
@MapperScan("com.tianyisoft.mymoney.dao")
public class MymoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymoneyApplication.class, args);
    }

}
