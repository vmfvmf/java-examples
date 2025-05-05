package com.vmfvmf.ioc.lifeCycleManagementLazyInit;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Lazy
@Component
public class MyService implements InitializingBean, DisposableBean, BeanPostProcessor {
	
	public MyService() {
        System.out.println("Expensive analytics setup...");
    }

    @PostConstruct
    public void initWithAnnotation() {
        System.out.println("PostConstruct - Setup resources");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean - Custom initialization");
    }

    @PreDestroy
    public void preDestroyHook() {
        System.out.println("PreDestroy - Prepare to shutdown");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean - Cleanup resources");
    }
    
    public Object postProcessBeforeInitialization(Object bean, String name) {
        System.out.println("Before init: " + name);
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String name) {
        System.out.println("After init: " + name);
        return bean;
    }
}
