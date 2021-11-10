package cn.yj.ioc.initdestory;

import cn.yj.demo.Animal;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-04
 */
public class TestBeanInitAndDestory {

	@Test
	public void testBeanInit() throws Exception{
		System.out.println("==start==");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/bean-init-destroy.xml");
		Car car = context.getBean(Car.class);
		System.out.println(car);
		System.out.println();
		context.close();
		Thread.sleep(3000);
	}


}
