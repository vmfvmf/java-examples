package com.vmfvmf.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
/**
 * 🔄 Behavior:
	A new instance is created each time it is requested
	
	Spring does not manage its full lifecycle (e.g., no @PreDestroy called)
	
	✅ Good for:
	State-full or temporary components (e.g., form builders, PDF writers)
 */
public class MyPrototypeBean {
    public MyPrototypeBean() {
        System.out.println("Prototype instance created");
    }
}