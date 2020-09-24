package com.ebay.demoironbank.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("email")
public class EmailMessageSender implements MessageSender {
    @Override
    public String send(Message message) {

        return "sent by email: "+message.getContent();
    }
}
