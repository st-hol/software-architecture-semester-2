//package ua.kpi.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Log4j2
//@Aspect
//@Component
//public class ServiceMethodsInformationAspect {
//
//    /**
//     * Parameter(s) passed to the called method logged
//     *
//     * @param joinPoint
//     */
//    @Before("applicationServiceMethodsPointcut()")
//    private void logPassedParams(JoinPoint joinPoint) {
//        log.info("Method {} called with parameters {}",
//                joinPoint.getSignature().toString(), Arrays.toString(joinPoint.getArgs()));
//    }
//
//    /**
//     * Execution time of the called method logged
//     *
//     * @param joinPoint
//     * @return
//     * @throws Throwable
//     */
//    @Around("applicationServiceMethodsPointcut()")
//    private Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        final Object returnValue = joinPoint.proceed();
//        long totalTime = System.currentTimeMillis() - startTime;
//        log.info("Method {} took {} milliseconds", joinPoint.getSignature().toString(), totalTime);
//        return returnValue;
//    }
//
//    /**
//     * Return value of the called method logged
//     *
//     * @param joinPoint
//     * @param returnValue
//     */
//    @AfterReturning(pointcut = "applicationServiceMethodsPointcut()", returning = "returnValue")
//    private void logMethodResult(JoinPoint joinPoint, Object returnValue) {
//        log.info("Method {} returned result {}", joinPoint.getSignature().toString(),
//                returnValue == null ? "[null value]" : returnValue.toString());
//    }
//
//    @SuppressWarnings("squid:S1186")
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void applicationServiceMethodsPointcut() {
//    }
//
//}
