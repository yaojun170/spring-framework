package cn.yj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-27
 */
public class App {
	public static void main(String[] args) {
		System.out.println("-sss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-demo.xml");
		Animal animal = (Animal) context.getBean("animal");
		DemoService demoService = (DemoService) context.getBean("demoService");
		System.out.println(animal);
		System.out.println(demoService.sayDemo());
	}
}
