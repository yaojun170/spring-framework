package cn.yj.aop.annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Description 代理A111ServiceImpl类
 * @Author yaojun
 * @Date 2020-11-26
 */
@Aspect
public class MyAnnotationAspect {
    @Pointcut("execution(* cn.yj.aop.service..*(..))")
    private void testAOP(){}

    @Before("testAOP()")
    public void beforeAdvice(){
        System.out.println(">>>AnnotationAspectAop1 beforeAdvice()");
    }

//    @Before("execution(* cn.yj.learn.aop.service.UserService.queryUserByName(..))")
    public void beforeAdvice2(){
        System.out.println("#####AnnotationAspectAop1 before 切面2222");
    }

    @After("testAOP()")
    public void afterAdvice(){
        System.out.println(">>>AnnotationAspectAop1 afterAdvice()");
    }

    @Around("testAOP()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        System.out.println(">>>AnnotationAspectAop1 aroundAdvice() before, args:"+ Arrays.toString(pjp.getArgs()));
        Object obj = null;
        try {
            obj = pjp.proceed(pjp.getArgs());
        } catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println(">>>AnnotationAspectAop1 aroundAdvice() after");
        return obj;
    }

    //
//    @Before("execution(* cn.yj.learn.aop.config.DogService.ffdd(..))")
    public void beforeAdviceXX(){
        System.out.println("#####AnnotationAspectAop1 before DOG切面-------");
    }
}
