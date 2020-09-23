package com.ebay.demoironbank.controllers;

import com.ebay.demoironbank.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/ironbank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("/total")
    public String totalAmount() {
        return " TOTAL AMOUNT OF IRON BANK " + bankService.total();

    }

    @GetMapping("/loan")
    public String loan(@RequestParam String name, @RequestParam int amount) {
        return bankService.loan(name, amount);
    }
}















