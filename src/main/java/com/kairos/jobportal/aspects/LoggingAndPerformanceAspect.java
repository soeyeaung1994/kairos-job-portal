package com.kairos.jobportal.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * @Author: Soe Ye Aung
 * @Date: 19/3/26
 * @Time: 1:29 pm
 */

@Aspect
@Component
@Slf4j
public class LoggingAndPerformanceAspect {

//    @Around("@annotation(com.kairos.jobportal.aspects.LogAspect)")
    @Around("execution(* com.kairos.jobportal..*.*(..))")
    public Object logAndMeasureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        Object[] methodArgs = joinPoint.getArgs();
        log.info("➡️ Entering method: {}", methodName);

        /*
        In Enterprise projects, some companies don't encourage developers to log methodArgs
        because in some scenarios, method args may contain user's sensitive information
        such as phone number, address and so on. In that case, we can disable printing method arguments.
         */
        log.info("📥 Arguments: {}", Arrays.toString(methodArgs));

        // Proceed with actual business method
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("✅ Method executed successfully: {}", methodName);
        log.info("⏱ Execution time: {} ms", executionTime);
        return result; // must return this joinPoint result so that actual business logic method will be invoked.
    }

}
