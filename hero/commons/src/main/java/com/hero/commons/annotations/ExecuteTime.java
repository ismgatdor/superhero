package com.hero.commons.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecuteTime {

	Logger logger = LoggerFactory.getLogger(ExecuteTime.class);
	
	@Around("@annotation(com.hero.commons.annotations.MeasureTime)")
	public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Method "+ pjp.getSignature()+ " ---> Execution time "+(endTime-startTime));
		return obj;
	}
}
