package com.spring.pdf.gen.advice;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.spring.pdf.gen.model.User;

@Component
@Aspect
public class LoggingAspect {

	public LoggingAspect() {
		System.out.println("Aspect Service Called");
	}

	@Pointcut(value = "execution(* com.spring.pdf.gen.service.UserService.*(..))")
	public void getPointCut() {

	}

	@SuppressWarnings("unchecked")
	@Around("getPointCut()")
	public List<User> logging(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		System.out.println("Enter to " + methodName);
		Object args = jp.proceed();
		System.out.println("Started Exceute");
		List<User> users = (List<User>) args;
		System.out.println("Return :" + users);
		return users;
	}
}
