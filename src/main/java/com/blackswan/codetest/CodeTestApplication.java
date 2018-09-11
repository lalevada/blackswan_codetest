package com.blackswan.codetest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Mark Andrews
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.blackswan.codetest")
public class CodeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeTestApplication.class, args);
    }
}
