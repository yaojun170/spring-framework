package cn.yj.ioc.factorybean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-01
 */
public class TestFactoryBean {
	@Test
	public void testFactofyBean(){
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-factorybean.xml");
		Object furniture = context.getBean("furniture");
		System.out.println(furniture);
		Object furniture2 = context.getBean("furniture");
	}

	@Test
	public void testFurnitureFactoryBean(){
		System.out.println("==start==");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("ioc/bean-factorybean.xml"));
		Object furniture =  xmlBeanFactory.getBean("&furniture");
		System.out.println(furniture);
//		furniture.move();
	}
}
