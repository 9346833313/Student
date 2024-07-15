package com.example.student.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.student.entity.Faculty;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* com.example.springboot.controller.FacultyController.*(..))")
	public void loggingPointCut() {
		// Pointcut for all methods in UserController
	}

	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before method invoked: {}", joinPoint.getSignature());
		logger.info("Request: {}", getRequestDetails(joinPoint.getArgs()));

		Object result = joinPoint.proceed();

		logger.info("After method invoked: {}", joinPoint.getSignature());

		return result;
	}

	@AfterReturning(pointcut = "loggingPointCut()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("Response: {}", getFacultyResponse(result));
	}

	private String getRequestDetails(Object[] args) {
		if (args != null && args.length > 0) {
			for (Object arg : args) {
				if (arg instanceof Faculty) {
					Faculty faculty = (Faculty) arg;
					return getFacultyResponse(faculty);
				}
			}
		}
		return "No Faculty data in the request";
	}

	private String getFacultyResponse(Object result) {
		if (result instanceof Faculty) {
			Faculty faculty = (Faculty) result;
			return "User [fname=" + faculty.getFname() + ", fsubject=" + faculty.getFsubject() + ", description="
					+ faculty.getDescription() + "]";
		}
		return "No Faculty data in the response";
	}
}
