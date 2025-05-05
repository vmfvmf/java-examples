package com.vmfvmf.ioc.profileDecoupledCode;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod") // Only active when 'prod' profile is active
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("PROD NOTIFIER: Email sent - " + message);
    }
}