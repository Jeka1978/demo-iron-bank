package com.ebay.demoironbank.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;


/**
 * @author Evgeny Borisov
 */
@RestController
public class DistributionController {




    private Map<String,MessageSender> map;



    public DistributionController(List<MessageSender> messageSenders) {
        map = messageSenders.stream().collect(toMap(MessageSender::getMyType, identity()));
    }

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


