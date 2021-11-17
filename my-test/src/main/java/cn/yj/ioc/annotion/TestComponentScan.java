package cn.yj.ioc.annotion;

import cn.yj.ioc.annotion.service.FooService;
import cn.yj.ioc.annotion.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-16
 */
public class TestComponentScan {
	@Test
	public void testScan(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/annotation/bean-scan.xml");
		FooService fooService = context.getBean(FooService.class);
		fooService.hell();
		UserService userService = context.getBean(UserService.class);
		String s = userService.queryName(1209);
		System.out.println(s);
	}
}
