package com.ebay.demoironbank.services;

import com.ebay.demoironbank.Bank;
import com.ebay.demoironbank.dao.BankRepo;
import com.ebayirnbank.ebayironbankstarter.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private PredictionService predictionService;

    @Override
    @Transactional
    public String loan(String name, int amount) {

        Bank bank = bankRepo.findAll().get(0);
        if (bank.getAmount() < amount) {
            throw new NotEnoughMoneyException("not enough money");
        }

        if (predictionService.willSurvive(name)) {
            bank.setAmount(bank.getAmount()-amount);
            return "loan was accepted";
        }else {
            return "rejected, you will not survive the winter, or we just don't like you";
        }


    }

    @Override
    public int total() {
       return bankRepo.findAll().get(0).getAmount();
    }
}





