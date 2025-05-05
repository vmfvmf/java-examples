package com.vmfvmf.ioc.profileDecoupledCode;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev") // Only active when 'dev' profile is active
public class DevNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("DEV NOTIFIER: Logging message instead of sending - " + message);
    }
}
