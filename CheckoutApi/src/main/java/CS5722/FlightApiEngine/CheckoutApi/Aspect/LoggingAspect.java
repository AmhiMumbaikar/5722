package CS5722.FlightApiEngine.CheckoutApi.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* CS5722.FlightApiEngine.CheckoutApi.Controller.CheckoutController.*(..))")
    public void logBeforeAllControllerMethods( JoinPoint joinPoint)
    {
        log.info("****LoggingAspect.logBeforeAllControllerMethods() : " + joinPoint.getSignature().getName());
    }
}