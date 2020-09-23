package com.ebay.demoironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTER_IS_COMING")
//spring.profiles.active
public class PredictionServiceImpl implements PredictionService {
    @Override
    public boolean willSurvive(String name) {
        return !name.toLowerCase().contains("stark");
    }
}
