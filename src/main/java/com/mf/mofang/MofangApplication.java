package com.mf.mofang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

// 下面这一行为新增数据库关联注解
@SpringBootApplication
@MapperScan("com.mf.mofang.dao")
public class MofangApplication {

    public static void main(String[] args) {

        // 文件上传的路径
        String filePath = "==";

        String currentpath = System.getProperty("user.dir");
        String absolutePath = new File("").getAbsolutePath();

        if (!currentpath.contains("bin")) {
            System.out.println("路径配置不正确,将使用默认");
        } else {
            String b = currentpath.substring(0, currentpath.indexOf("bin")) + "www\\file\\";
            System.out.println("文件上传的路径 " + b);
            filePath = b;
        }


        SpringApplication.run(MofangApplication.class, args);
    }

}
