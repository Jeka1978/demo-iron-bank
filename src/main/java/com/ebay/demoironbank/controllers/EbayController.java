package com.ebay.demoironbank.controllers;

import com.ebay.demoironbank.Bank;
import com.ebayirnbank.ebayironbankstarter.FrontendController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Evgeny Borisov
 */

@FrontendController
@RequestMapping("/api")
public class EbayController {


    @GetMapping("/bank/info")
    public Bank getBank(){
        return Bank.builder().id(17).amount(42).build();
    }
}
