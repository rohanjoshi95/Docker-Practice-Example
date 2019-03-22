package com.example.logging;


import java.io.Serializable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**This class is used to trace the entry and exit of the method.
 * 
 * @author anangupt
 *
 */
@Aspect
@Component
public class LoggingAspect implements Serializable {

	private static final long serialVersionUID = -3286750827970793286L;
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class); 
	
	/**This method logs when execution enters into the method.
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.example..*(..))")
	public void entering(JoinPoint joinPoint) {
		
		LOGGER.info("Enterin into the method.{}", joinPoint.getStaticPart().getSignature());
	}
	
	/**This method logs when execution exit from the method.
	 * 
	 * @param joinPoint
	 */
	@After("execution(* com.example..*(..))")
	public void exit(JoinPoint joinPoint) {
		LOGGER.info("exit from the method.{}", joinPoint.getStaticPart().getSignature());
	}
	
}
