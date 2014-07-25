package com.netsol.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * @author  Siddhartha Bhatia
 * @version 1.0
 * @since   2014-07-07  
 * 
 */

@Aspect
public class ServiceAuditAspect {

	static final Logger logger = Logger.getLogger(ServiceAuditAspect.class);

    @Pointcut("execution(* com.app.service.*.*(..))")
    public void serviceMethods(){
        //
    }
    
    @Before("serviceMethods()")
    public void beforeMethod() {
    	logger.info("-------------------------------Method Execution BEGIN -------------------------------------------------------");
        //logger.info("before method");
    }

    @Around("serviceMethods()")
    public Object aroundMethod(ProceedingJoinPoint joinpoint) {
        try {
            long start = System.nanoTime();
            Object result = joinpoint.proceed();
            long end = System.nanoTime();
            logger.info(String.format("%s took %d ns", joinpoint.getSignature(), (end - start)));
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
      
    @After("serviceMethods()")
    public void afterMethod() {
    	logger.info("-------------------------------Method Execution END -------------------------------------------------------");
    }    
}