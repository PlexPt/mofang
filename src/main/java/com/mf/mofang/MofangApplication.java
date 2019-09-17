package com.mf.mofang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 下面这一行为新增数据库关联注解
@SpringBootApplication
@MapperScan("com.mf.mofang.dao")
public class MofangApplication {

    public static void main(String[] args) {
        SpringApplication.run(MofangApplication.class, args);
    }

}
