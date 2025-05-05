package com.vmfvmf.ioc.profileDecoupledCode;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String user, String message) {
        System.out.println("Notifying user: " + user);
        notifier.send(message);
    }
}