package com.unicom.microserv.asyntest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author ymx
 * @Name Asyntest01Application
 * @CreateTime 2022/8/16
 * @ProjectName AsynTest01
 * @Description:
 */

@SpringBootApplication
@ComponentScan("com.unicom.microserv.asyntest01")
public class Asyntest01Application {
    public static ConfigurableApplicationContext ac;
    public static void main(String[] args) {
        ac = SpringApplication.run(Asyntest01Application.class, args);
    }
}
