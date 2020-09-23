package com.ebay.demoironbank.dao;

import com.ebay.demoironbank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface BankRepo extends JpaRepository<Bank,Integer> {


}
