package com.ebay.demoironbank;

import com.ebay.demoironbank.dao.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
public class BankFillerContextListener {

    @Autowired
    private BankRepo bankRepo;

    @Transactional
    @EventListener(ContextRefreshedEvent.class)
    public void fillBank(){
        Bank bank = Bank.builder().amount(100).build();
        bankRepo.save(bank);
    }
}
