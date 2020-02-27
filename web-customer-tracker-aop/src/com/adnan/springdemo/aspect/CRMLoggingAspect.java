package com.adnan.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// setup looger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.adnan.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.adnan.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.adnan.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void beforeAddAcountAdvice(JoinPoint theJoinpoint) {
		myLogger.info("======>>> Executing @Before advice on method");
		// display the method signature
		myLogger.info("\t  The methode signature : " + theJoinpoint.getSignature());
		// display the method arguments
		if (theJoinpoint.getArgs().length != 0) {
			for (Object c : theJoinpoint.getArgs()) {
				if (c != null) {
					myLogger.info("\t  The arugmets : " + c);
				}
			}
		} else {
			myLogger.info("\t  The mothod has no arguments!!");
		}
	}

	// add @AfterReturning advice
	@AfterReturning
	(pointcut = "forAppFlow()",
	 returning = "theResult")
	public void afterReturning(JoinPoint theJoinpoint , Object theResult) {
		// display method we are returning from 
		myLogger.info("======>>> Executing @AfterReturning advice on method");
		// display the method signature
		myLogger.info("\t  The methode signature : " + theJoinpoint.getSignature());
		// display the method arguments
		if (theJoinpoint.getArgs().length != 0) {
			for (Object c : theJoinpoint.getArgs()) {
				if (c != null) {
					myLogger.info("\t  The arugmets : " + c);
				}
			}
		} else {
			myLogger.info("\t  The mothod has no arguments!!");
		}
		
		// display the returned data
		myLogger.info("======>>> result: "+ theResult);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
