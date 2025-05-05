package com.vmfvmf.ioc.scope;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
/**
 * 🔄 Behavior:
	One instance per user session
	
	Lives as long as session lives
	
	✅ Useful for:
	Caching user info
	
	Login/session-specific state
 */
public class SessionScopedBean {
    private final String sessionId = UUID.randomUUID().toString();
    public String getSessionId() { return sessionId; }
}