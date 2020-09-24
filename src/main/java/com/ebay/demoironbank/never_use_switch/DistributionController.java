package com.ebay.demoironbank.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@RestController
public class DistributionController {


    @Autowired
    private Map<String,MessageSender> map;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        String type = message.getDistributionType();
        MessageSender messageSender = map.get(type);
        if (messageSender == null) {
            throw new UnsupportedOperationException(type + " not supported yet");
        }
       return messageSender.send(message);
    }
}
