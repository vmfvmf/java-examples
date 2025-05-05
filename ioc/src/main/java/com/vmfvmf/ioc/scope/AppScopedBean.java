package com.vmfvmf.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
/**
 * 🔄 Behavior:
	One instance per ServletContext
	
	Shared across all sessions and requests
 */
public class AppScopedBean {
    public AppScopedBean() {
        System.out.println("Application-wide bean created");
    }
}