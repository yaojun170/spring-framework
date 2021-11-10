package cn.yj.aop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class MyLogRecorder {
	public void before(JoinPoint jp){
		System.out.println("---执行前--"+jp.getTarget().getClass()+",args="+ Arrays.toString(jp.getArgs()));
	}

	public void after(){
		System.out.println("------执行后----");
	}
}
