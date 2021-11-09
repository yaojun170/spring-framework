package cn.yj.extension.event;

import cn.yj.demo.Animal;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-04
 */
public class TestApplicationListener {

	@Test
	public void testApplicationListener(){
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-extend-event.xml");
		context.start();
		Animal animal = (Animal) context.getBean("animal");
		System.out.println(animal);
	}

	/**
     * 注意：通过BeanFactory方式获取bean，不会自动注册BeanPostProcessor
	 */
	@Test
	public void testPostProcessor(){
		System.out.println("-------");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("ioc/bean-extend-beanpostprocessor.xml"));
		Animal animal = (Animal) xmlBeanFactory.getBean("animal");
		System.out.println(animal);
	}


}
