package cn.yj.ioc.loop;

import cn.yj.ioc.autowire.Company;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-28
 */
public class TestBeanLoop {
	@Test
	public void testConstructInjectLoop(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-aop-loop.xml");
	}

}
