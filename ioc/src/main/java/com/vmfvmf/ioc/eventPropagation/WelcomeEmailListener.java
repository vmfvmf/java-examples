package com.vmfvmf.ioc.eventPropagation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {

    @EventListener
    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println("Sending welcome email to " + event.getUsername());
    }
}