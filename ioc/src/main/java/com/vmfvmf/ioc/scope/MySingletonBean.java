package com.vmfvmf.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // Optional, it's the default
/**
 * 🔄 Behavior:
	Created once when Spring starts
	
	All injections point to the same instance
	
	Shared across all consumers
	
	✅ Good for:
	Stateless services
	
	Utility components
	
	Shared configuration
 */
public class MySingletonBean {
    public MySingletonBean() {
        System.out.println("Singleton instance created");
    }
}