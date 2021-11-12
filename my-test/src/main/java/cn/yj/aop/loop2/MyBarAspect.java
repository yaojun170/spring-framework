package cn.yj.aop.loop2;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description 代理A111ServiceImpl类
 * @Author yaojun
 * @Date 2020-11-26
 */
@Component
@Aspect
public class MyBarAspect {
    @Pointcut("execution(* cn.yj.aop.loop2.Bar.*(..))")
    private void testBarAop(){}

    @Before("testBarAop()")
    public void beforeAdvice(){
        System.out.println(">>>MyBarAspect beforeAdvice()");
    }

}
