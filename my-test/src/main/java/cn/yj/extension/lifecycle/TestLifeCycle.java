package cn.yj.extension.lifecycle;

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
public class TestLifeCycle {

	@Test
	public void testLifeCycle() throws Exception{
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-extend-lifecycle.xml");
//		context.registerShutdownHook();
//		context.start();
		Animal animal = (Animal) context.getBean("animal");
		System.out.println(animal);
		System.out.println();
		Thread.sleep(3000L);
		context.stop();
	}


}
