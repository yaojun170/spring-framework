package cn.yj.aop.demo;

import cn.yj.aop.service.DogTool;
import cn.yj.aop.service.UserService;
import cn.yj.aop.service.UserServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class TestProxyFactory {
	@Test
	public void testInterfaceProxy(){
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new UserServiceImpl());
		pf.addInterface(UserService.class);
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();

		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("queryName");
		pointcut.addMethodName("insertUser");
		advisor.setPointcut(pointcut);
		advisor.setAdvice(new MethodBeforeAdvice() {
							  @Override
							  public void before(Method method, Object[] args, Object target) throws Throwable {
								  System.out.println("before Advice..."+method.getName());
							  }
						  }
		);
		pf.addAdvisor(advisor);

		UserService us = (UserService)pf.getProxy();
		String s = us.queryName(2009);
		System.out.println(s);
	}


	@Test
	public void testProxyFactory(){
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new DogTool());
//		pf.addInterface();//不设置接口属性的话使用CGLIB代理

		//织入切面
		pf.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("---环绕切面前----");
				long s1 = System.currentTimeMillis();
				Object ret = invocation.proceed();
				System.out.println("---环绕切面后----耗时："+(System.currentTimeMillis()-s1));
				return ret;
			}
		});


		DogTool proxy = (DogTool)pf.getProxy();
		System.out.println(proxy.eat("骨头"));
	}

	@Test
	public void testProxyFactoryMultiAdvice(){
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new DogTool());


		pf.addAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("===切面 before==");
			}
		});

		pf.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("---环绕切面前----");
				long s1 = System.currentTimeMillis();
				Object ret = invocation.proceed();
				System.out.println("---环绕切面后----耗时："+(System.currentTimeMillis()-s1));
				return ret;
			}
		});

		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setAdvice(new AfterReturningAdvice() {
			@Override
			public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
				System.out.println("===----切面 AFTER 222===");
			}
		});
		pf.addAdvisor(advisor);

		DogTool proxy = (DogTool)pf.getProxy();
		System.out.println(proxy.eat("骨头"));
	}

	@Test
	public void testProxyFactoryWithPointcut(){
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new DogTool());

		//织入切面
		pf.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("---环绕切面前----");
				long s1 = System.currentTimeMillis();
				Object ret = invocation.proceed();
				System.out.println("---环绕切面后----耗时："+(System.currentTimeMillis()-s1));
				return ret;
			}
		});

		//
		AspectJExpressionPointcutAdvisor aspectJExpressionPointcutAdvisor = new AspectJExpressionPointcutAdvisor();
		aspectJExpressionPointcutAdvisor.setExpression("execution(* cn.yj.aop.service.DogTool.eat(..))");
		aspectJExpressionPointcutAdvisor.setAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("---测试切面 before expression模式----");
			}
		});
		pf.addAdvisor(aspectJExpressionPointcutAdvisor);

		DogTool proxy = (DogTool)pf.getProxy();
		System.out.println(proxy.eat("骨头"));
	}

	@Test
	public void testIntroduction(){
		ProxyFactory pf = new ProxyFactory();
		new DefaultIntroductionAdvisor(new IntroductionInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("我是引介增强的方法体~~~invoke");
				return invocation.proceed();
			}

			@Override
			public boolean implementsInterface(Class<?> intf) {
				return true;
			}
		}, UserService.class);
	}

}
