package cn.yj.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-27
 */
public class TestDemo {
	Logger logger = LoggerFactory.getLogger(TestDemo.class);

	@Test
	public void test1(){
		logger.info("-sss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo/bean-demo.xml");
		Animal animal = (Animal) context.getBean("animal");
		DemoService demoService = (DemoService) context.getBean("demoService");
		logger.info(animal.toString());
		logger.info(demoService.sayDemo());
	}
}
