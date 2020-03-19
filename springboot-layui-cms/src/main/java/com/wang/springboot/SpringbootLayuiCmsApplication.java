package com.wang.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.wang.springboot.*.mapper"})
public class SpringbootLayuiCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLayuiCmsApplication.class, args);
    }

}
