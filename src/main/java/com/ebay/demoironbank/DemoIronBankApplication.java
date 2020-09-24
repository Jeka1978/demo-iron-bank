package com.ebay.demoironbank;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoIronBankApplication {

    @Value("${JAVA_HOME}")
    private String javaHome;


    @PostConstruct
    public void  init(){
        System.out.println(javaHome);
    }


    @Bean
    public Faker faker(){
        return new Faker();
    }








    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        ConfigurableApplicationContext context = SpringApplication.run(DemoIronBankApplication.class, args);

        System.out.println();
    }

}









