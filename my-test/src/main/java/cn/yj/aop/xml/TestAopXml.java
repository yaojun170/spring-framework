package cn.yj.aop.xml;

import cn.yj.aop.service.DogTool;
import cn.yj.aop.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class TestAopXml {
	@Test
	public void testXml(){
		System.out.println("---sss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/bean-aop-xml.xml");
		DogTool dt = context.getBean("dog", DogTool.class);
		try {
			System.out.println("返回："+dt.eat("bone"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testXml2(){
		System.out.println("---sss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/bean-aop-xml2.xml");
		DogTool dt = context.getBean("dog", DogTool.class);
		UserService us = context.getBean(UserService.class);
		try {
			System.out.println("返回dog："+dt.eat("bone"));
			System.out.println("返回user："+us.queryName(1002));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
