package com.ebay.demoironbank.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
public class EbayProductController {

    @PostMapping("/api/product")
    public String handleProduct(@RequestBody EbayProductNIS ebayProductNIS) {
        System.out.println(ebayProductNIS+" was handled");
        return "OK";
    }
}
