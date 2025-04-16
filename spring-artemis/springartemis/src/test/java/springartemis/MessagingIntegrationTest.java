package springartemis;

import static org.awaitility.Awaitility.waitAtMost;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.ComponentScan;

import vmfvmf.com.springartemis.messager.NotificationMessage;
import vmfvmf.com.springartemis.messager.NotificationReceiver;
import vmfvmf.com.springartemis.messager.NotificationSender;



@SpringBootTest
class MessagingIntegrationTest {
	
	@SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan(basePackages = "vmfvmf.com")
    static class TestConfig {}

    @Autowired
    private NotificationSender sender;
    
    @SpyBean
    private NotificationReceiver receiver;

    @Test
    void testMessageSendAndReceive() {    	
        NotificationMessage message = new NotificationMessage();
        message.setTitle("Hello");
        message.setBody("This is a test message");

        sender.send(message);
        
        waitAtMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
        	verify(receiver, times(1)).receive(argThat(argument -> argument.getBody().contentEquals("This is a test message")));
        });
        
    }
}