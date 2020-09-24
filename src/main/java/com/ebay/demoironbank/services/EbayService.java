package com.ebay.demoironbank.services;

import com.ebay.demoironbank.InjectRandomName;
import com.ebayirnbank.ebayironbankstarter.ConditionalOnProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@Service
public class EbayService {


    @InjectRandomName
    private String name;

    public EbayService() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void init(){

        System.out.println("init method");
        System.out.println("name = " + name);
    }


    @EventListener(ContextRefreshedEvent.class)
    public void doWork(){
        System.out.println("Context started");
        System.out.println("Working....");
    }


    public static void main(String[] args) {
        System.out.println("123");
    }

}



