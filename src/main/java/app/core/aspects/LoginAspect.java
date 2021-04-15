package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import app.core.exceptions.CouponSystemException;
import app.core.services.ClientService;

@Component
@Aspect
public class LoginAspect {
	
	@Pointcut("execution(* app.core.services.*.*(..))")
	public void allServices() {
	};
	
	@Pointcut("execution(* app.core.services.*.login(..))")
	public void login() {
	};
	
	@Pointcut("execution(* app.core.services.JobService.*(..))")
	public void job() {
	};
	
	
//	@Before("allServices() && ! login() && ! job()")
//	public void checkLogin(JoinPoint jp) throws CouponSystemException {
//		ClientService client = (ClientService)jp.getTarget();
//		if (!client.isLogged()) {
//			throw new CouponSystemException("The operation blocked! - you are not logged in");
//		}
//	}

	
	@Around("allServices() && ! login() && ! job()")
	public Object checkLogin(ProceedingJoinPoint joinPoint) throws CouponSystemException, Throwable {
		ClientService client = (ClientService)joinPoint.getTarget();
		if (!client.isLogged()) {
			throw new CouponSystemException("The operation blocked! - you are not logged in");//System.out.println("The operation blocked! - you are not logged in");
		} 
		else {
			return joinPoint.proceed();
		}
	}
}
