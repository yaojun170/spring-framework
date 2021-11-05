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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo/bean-demo.xml");
		Animal animal = (Animal) context.getBean("animal");
		System.out.println(animal);
	}

}
