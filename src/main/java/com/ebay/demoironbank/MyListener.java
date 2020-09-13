package com.ebay.demoironbank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${sss}")
    private String s;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("URA!!!!!!!!!"+s);
    }
}
