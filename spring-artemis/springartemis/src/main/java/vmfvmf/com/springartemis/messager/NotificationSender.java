package vmfvmf.com.springartemis.messager;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {
	
	private final JmsTemplate jmsTemplate;

    public NotificationSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(NotificationMessage message) {
        jmsTemplate.convertAndSend("notification.queue", message);
    }
}
