package com.ebay.demoironbank.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("sms")
public class SmsMessageSender implements MessageSender {
    @Override
    public String send(Message message) {
        return "sent by sms: "+message.getContent();
    }
}
