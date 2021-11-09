package cn.yj.extension.beanfactorypostprocessor;

import cn.yj.demo.Animal;
import cn.yj.demo.DemoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-04
 */
public class TestBeanFactoryPostProcessor {

	@Test
	public void testBeanFactoryPostProcessor(){
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-extend-beanfactorypostprocessor.xml");
		Animal animal = (Animal) context.getBean("animal");
		System.out.println(animal);
	}

	@Test
	public void testBeanDefinitionRegsitryPostProcessor(){
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-extend-beanfactorypostprocessor.xml");
		MyHouse myHouse = context.getBean("myHouse", MyHouse.class);
		System.out.println(myHouse);
	}

	@Test
	public void testBeanPlaceHolder(){
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-extend-propertyplaceholder.xml");
		MyHouse myHouse = context.getBean("myHouse2", MyHouse.class);
		System.out.println(myHouse);
	}

}
