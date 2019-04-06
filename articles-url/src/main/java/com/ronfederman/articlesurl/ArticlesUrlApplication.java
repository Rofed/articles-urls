package com.ronfederman.articlesurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArticlesUrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticlesUrlApplication.class, args);
    }

}
