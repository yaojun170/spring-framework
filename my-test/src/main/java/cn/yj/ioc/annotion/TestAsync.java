package cn.yj.ioc.annotion;

import cn.yj.demo.Door;
import cn.yj.ioc.annotion.service.MyAsyncService;
import cn.yj.ioc.annotion.service.UserService;
import cn.yj.ioc.autowire.Employee;
import cn.yj.ioc.factorybean.Desk;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public class TestAsync {
	@Test
	public void testAsync() throws Exception {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		MyAsyncService mas = ac.getBean(MyAsyncService.class);
		mas.sendEmail("jaylee@sogou-inc.com","welcome sogou family");
		mas.downloadMovie("spiderman3.mov");
		System.in.read();
	}

	@Test
	public void testAsyncWithFuture() throws Exception {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		MyAsyncService mas = ac.getBean(MyAsyncService.class);
		UserService us = ac.getBean(UserService.class);
		System.out.println("---------");
		System.out.println("");
		System.out.println(">>>>>>>>>>>"+mas.downloadMovie("magent:ironman.mp4"));
		Future<String> future = mas.downloadPic("www.baidu.com/1.html");
		mas.sendEmail("xiaowang@sogou-inc.com","welcome sogou family");
		System.out.println(us.insertUser("elon musk"));
		System.out.println("#############"+future.get());

		Thread.sleep(100000);
	}


}
