package cn.yj.ioc.annotion;

import cn.yj.demo.Animal;
import cn.yj.ioc.annotion.service.FooService;
import cn.yj.ioc.annotion.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
public class TestAnnotationStart {
	@Test
	public void testAnnotationStart(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Animal animal = ac.getBean("animal", Animal.class);
		System.out.println(animal);
	}

	@Test
	public void testAnnotationScan(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		UserService us = ac.getBean(UserService.class);
		FooService fs = ac.getBean(FooService.class);
		System.out.println(us.queryName(1009));
		fs.hell();
	}
}
