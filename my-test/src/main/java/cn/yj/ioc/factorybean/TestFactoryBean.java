package cn.yj.ioc.factorybean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-01
 */
public class TestFactoryBean {
	@Test
	public void testFurnitureFactoryBean(){
		System.out.println("==start==");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("ioc/bean-factorybean.xml"));
		Object furniture =  xmlBeanFactory.getBean("&furniture");
		System.out.println(furniture);
//		furniture.move();
	}
}
