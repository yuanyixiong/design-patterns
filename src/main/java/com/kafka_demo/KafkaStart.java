package com.kafka_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/1/30
 */
@SpringBootApplication
public class KafkaStart {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(KafkaStart.class, args);

        app.getBean(KafkaSender.class).send("Hello==========================>>>");
        System.out.println("over");
    }

}
