package com.example.batchprocessing;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class DemoSpringbatch101Application {

    public static void main(String[] args) {
//        SpringApplication.run(DemoSpringbatch101Application.class, args);
        System.exit(SpringApplication.exit(SpringApplication.run(DemoSpringbatch101Application.class, args)));

    }

}
