package vmfvmf.com.springartemis.messager;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationReceiver {

    @JmsListener(destination = "notification.queue")
    public void receive(NotificationMessage message) {
        System.out.println("Received message: " + message.getTitle());
    }
}

