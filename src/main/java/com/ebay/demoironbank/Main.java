package com.ebay.demoironbank;/**
 * @author Evgeny Borisov
 */

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@EventListener(ContextRefreshedEvent.class)
public @interface Main {
}
