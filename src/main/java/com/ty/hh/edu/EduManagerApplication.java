package com.ty.hh.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.ty.hh.edu.mapper")  // 扫描 Mapper 接口的包
public class EduManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduManagerApplication.class, args);
    }

}
