package com.vmfvmf.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;
import org.springframework.scheduling.annotation.EnableAsync;

import com.vmfvmf.ioc.aspect.OrderService;
import com.vmfvmf.ioc.centralizedConfig.WelcomeMsg;
import com.vmfvmf.ioc.eventPropagation.UserService;
import com.vmfvmf.ioc.profileDecoupledCode.NotificationService;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
@EnableCaching
@EnableAsync
public class ServerApplication implements ApplicationRunner {
	
	/**
	 * DEPENDENCY INJECTION
	 */
	// Field injection, poor for testability
	@Autowired
    private OrderService orderService;
	
	private WelcomeMsg welcomeMsg;
	
	// setter injection
	@Autowired
	public void setWelcomeMsg(WelcomeMsg welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
	
	
    private UserService userService;
    private NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	
	// injection through constructor, most preferred
	public ServerApplication(NotificationService notificationService, UserService userService) {
		this.notificationService = notificationService;
		this.userService = userService;
	}
	
	public void run(ApplicationArguments args) {
		// profile
		notificationService.notifyUser("alice", "Your password will expire soon.");
		
		// aspect
		orderService.placeOrder("Laptop", 2);
		orderService.cancelOrder("ORD-001");
		
		System.out.println(welcomeMsg.getMsg());
		
		userService.createUser("Test Name");
	}

}

