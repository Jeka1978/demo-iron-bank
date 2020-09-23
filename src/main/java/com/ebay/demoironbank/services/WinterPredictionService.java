package com.ebay.demoironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTER_IS_HERE")
public class WinterPredictionService implements PredictionService {
    @Override
    public boolean willSurvive(String name) {
        return name.toLowerCase().contains("lanister");
    }
}
