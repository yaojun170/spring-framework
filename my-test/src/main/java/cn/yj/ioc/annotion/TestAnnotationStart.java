package cn.yj.ioc.annotion;

import cn.yj.aop.service.DogTool;
import cn.yj.demo.Animal;
import cn.yj.demo.DemoService;
import cn.yj.ioc.annotion.service.FooService;
import cn.yj.ioc.annotion.service.UserService;
import cn.yj.ioc.factorybean.Desk;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
public class TestAnnotationStart {
	//AnnotationConfigApplicationContext的多个构造函数
	//<context:component-scan>
	@Test
	public void testAnnotationStart(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Animal animal = ac.getBean("animal", Animal.class);
		System.out.println(animal);
		UserService us = ac.getBean(UserService.class);
		FooService fs = ac.getBean(FooService.class);
		System.out.println(us.queryName(1009));
		fs.hell();
	}

	@Test
	public void testAnnotationScan(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		UserService us = ac.getBean(UserService.class);
		FooService fs = ac.getBean(FooService.class);
		System.out.println(us.queryName(1009));
		fs.hell();
	}

	@Test
	public void testConfigurationParser(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		UserService us = ac.getBean(UserService.class);
		FooService fs = ac.getBean(FooService.class);
		System.out.println(us.queryName(1009));
		fs.hell();
		System.out.println("======");
		Animal animal = ac.getBean("animal", Animal.class);
		System.out.println(animal);
		System.out.println("-------");
		Desk desk = ac.getBean(Desk.class);
		desk.move();
		System.out.println(">>>>>>>");
		System.out.println(ac.getEnvironment().getProperty("house.location"));
		System.out.println("<<<<<<<<<<<<<");
		DemoService demoService = ac.getBean(DemoService.class);
		demoService.sayDemo();
	}

	@Test
	public void testLiteMode(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Animal animal = ac.getBean("animal", Animal.class);
		System.out.println(animal);
		DogTool dogTool = ac.getBean(DogTool.class);
		dogTool.eat("mifan");
	}
}
