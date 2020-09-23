package com.ebay.demoironbank.services;

/**
 * @author Evgeny Borisov
 */
public interface BankService {
    String loan(String name, int amount);

    int total();
}
