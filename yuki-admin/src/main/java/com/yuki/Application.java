package com.yuki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 默认扫描当前包下的所有Bean，省略了@ComponentScan注解指定
 */
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
