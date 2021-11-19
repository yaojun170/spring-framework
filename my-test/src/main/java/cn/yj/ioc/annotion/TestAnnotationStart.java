package cn.yj.ioc.annotion;

import cn.yj.aop.service.DogTool;
import cn.yj.demo.Animal;
import cn.yj.demo.DemoService;
import cn.yj.demo.Room;
import cn.yj.ioc.annotion.service.FooService;
import cn.yj.ioc.annotion.service.MergeService;
import cn.yj.ioc.annotion.service.UserService;
import cn.yj.ioc.autowire.Employee;
import cn.yj.ioc.factorybean.Desk;
import cn.yj.ioc.initdestory.Car;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

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
		System.out.println(Arrays.asList(ac.getBeanDefinitionNames()));
		Employee employee = (Employee) ac.getBean("hahaEmp");
		System.out.println(employee);
//		UserService us = ac.getBean(UserService.class);
//		FooService fs = ac.getBean(FooService.class);
//		System.out.println(us.queryName(1009));
//		fs.hell();
	}

	@Test
	public void testBeanRely(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Room room = ac.getBean(Room.class);
		Desk desk = ac.getBean(Desk.class);
		System.out.println(room);
		System.out.println(room.getDesk());
		System.out.println(desk);
	}

	@Test
	public void testBeanInitDestroy() throws InterruptedException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Car car = ac.getBean(Car.class);
		System.out.println(car);
		Thread.sleep(5000);
		ac.close();
	}

	@Test
	public void testAnnotationScan(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("cn.yj.ioc.annotion.service");
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
	public void testAutowired(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		MergeService ms = ac.getBean(MergeService.class);
		ms.merge();
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
