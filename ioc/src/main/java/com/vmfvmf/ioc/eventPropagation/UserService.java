package com.vmfvmf.ioc.eventPropagation;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ApplicationEventPublisher publisher;

    public UserService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void createUser(String username) {
        System.out.println("Creating user: " + username);
        publisher.publishEvent(new UserCreatedEvent(username));
    }
}