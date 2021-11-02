package cn.yj.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-27
 */
public class TestBeanStart {
	Logger logger = LoggerFactory.getLogger(TestBeanStart.class);

	@Test
	public void testXmlContext(){
		logger.info("-sss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo/bean-demo.xml");
		Animal animal = (Animal) context.getBean("animal");
		DemoService demoService = (DemoService) context.getBean("demoService");
		logger.info(animal.toString());
		logger.info(demoService.sayDemo());
	}

	@Test
	public void testXmlBeanFactory(){
		logger.info("====");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("demo/bean-demo.xml"));
		BeanDefinition animalBeanD = xmlBeanFactory.getBeanDefinition("animal");
		System.out.println(animalBeanD);
		Object animal1 = xmlBeanFactory.getBean("animal");
		Animal animal = xmlBeanFactory.getBean(Animal.class);
		logger.info(animal.toString());
	}


}
