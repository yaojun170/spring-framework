package cn.yj.ioc;

import cn.yj.ioc.autowire.Company;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-28
 */
public class TestAutowire {
	@Test
	public void testByName(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-autowire.xml");
		Company cc = context.getBean(Company.class);
		System.out.println(cc);
	}

	@Test
	public void testByType(){

	}
}
