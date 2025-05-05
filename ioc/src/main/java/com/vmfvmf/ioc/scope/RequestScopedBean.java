package com.vmfvmf.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
/**
 * 🔄 Behavior:
	New instance per HTTP request
	
	Useful for request-specific data (e.g., per-user logging)
	
	✅ Needs:
	Web app + Spring Web context
	
	proxyMode to make it injectable into singleton beans
 */
public class RequestScopedBean {
    public RequestScopedBean() {
        System.out.println("Request-scoped bean created");
    }
}