package com.project.school.management.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

	@Before("execution(* com.project.school.management.controller..*(..))")
	public void beforeControllerAdvice(JoinPoint joinPoint) {
		log.info("Inside Controller Method :::" + joinPoint.getSignature().toShortString());
		log.info("Controller Payload :::" + Arrays.asList(joinPoint.getArgs()));
	}

	@Before("execution(* com.project.school.management.service..*(..))")
	public void beforeServiceAdvice(JoinPoint joinPoint) {
		log.info("Inside service Method :::" + joinPoint.getSignature().toShortString());
		log.info("Service Payload :::" + Arrays.asList(joinPoint.getArgs()));
	}

}
