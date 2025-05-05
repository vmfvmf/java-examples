package com.vmfvmf.ioc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Marks this class as an Aspect
@Component // Enables Spring to manage this bean
/***
 * 💡 Advanced Notes
	You can use @After, @Around, @AfterReturning, and @AfterThrowing for more control.

	You can limit the pointcut to specific methods using more precise expressions.

	For reusable pointcuts, you can define them in separate methods with @Pointcut
 */
public class LoggingAspect {

    // Pointcut expression for any method in the service package
    @Before("execution(* com.vmfvmf.ioc.centralizedConfig.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // Logging before method execution
        System.out.println("LOG: Calling method " + joinPoint.getSignature().getName() +
            " with arguments: " + java.util.Arrays.toString(joinPoint.getArgs()));
    }
}

