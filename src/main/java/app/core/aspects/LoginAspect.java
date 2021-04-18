package app.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
	
	/**
	 * Operates in each time that an action required the user
	 * to be logged in to the system. (every service method).
	 * If the user try to run a service method without being logged,
	 * the operation will be blocked by throwing an exception.
	 * @throws CouponSystemException
	 */
	@Around("allServices() && ! login() && ! job()")
	public Object checkLogin(ProceedingJoinPoint joinPoint) throws CouponSystemException, Throwable {
		ClientService client = (ClientService)joinPoint.getTarget();
		if (!client.isLogged()) {
			throw new CouponSystemException("The operation blocked! - you are not logged in");
		} 
		else {
			return joinPoint.proceed();
		}
	}
}
