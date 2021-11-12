package cn.yj.aop.annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class MyAnnotationLoggerAspect {
    @Pointcut("execution(* cn.yj.aop.service..*(..))")
    private void testAOP2Logger(){}

    @Before("testAOP2Logger()")
    public void beforeAdvice(){
        System.out.println(">>>====MyAnnotationLoggerAspect beforeAdvice()-----");
    }

    @After("testAOP2Logger()")
    public void afterAdvice(){
        System.out.println(">>>=====MyAnnotationLoggerAspect afterAdvice()-----");
    }

    @Around("testAOP2Logger()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        System.out.println(">>>====MyAnnotationLoggerAspect aroundAdvice() before, args:"+ Arrays.toString(pjp.getArgs()));
        Object obj = null;
        try {
            obj = pjp.proceed(pjp.getArgs());
        } catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println(">>>====MyAnnotationLoggerAspect aroundAdvice() after");
        return obj;
    }

}
