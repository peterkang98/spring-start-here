package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class SecurityAspect {
  private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

  @Around(value= "@annotation(ToLog)")
  public Object secure(ProceedingJoinPoint joinPoint) throws Throwable{
    logger.info("security aspect: Calling the intercepted method");
    Object returnedValue = joinPoint.proceed();
    logger.info("security aspect: Method executed and returned "+returnedValue);
    return returnedValue;
  }
}
