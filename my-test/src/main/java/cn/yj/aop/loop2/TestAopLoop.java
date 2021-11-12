package cn.yj.aop.loop2;

import cn.yj.aop.service.DogTool;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class TestAopLoop {
	//Bar<->Foo,且Bar是代理
	@Test
	public void testAopLoop(){
		System.out.println("---startsss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/bean-aop-loop2.xml");
		Bar bar = context.getBean(Bar.class);
		bar.fuck();
	}


}
