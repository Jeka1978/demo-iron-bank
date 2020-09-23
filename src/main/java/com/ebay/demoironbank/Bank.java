package com.ebay.demoironbank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bank {

    @Id
    @GeneratedValue
    private int id;

    private int amount;
}







