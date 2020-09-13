package com.ebay.demoironbank;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
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
        ConfigurableApplicationContext context = SpringApplication.run(DemoIronBankApplication.class, args);

        System.out.println();
    }

}









