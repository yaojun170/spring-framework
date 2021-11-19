package cn.yj.ioc.annotion;

import cn.yj.demo.Door;
import cn.yj.ioc.annotion.po.BeanOne;
import cn.yj.ioc.annotion.po.BeanTwo;
import cn.yj.ioc.autowire.Employee;
import cn.yj.ioc.factorybean.Desk;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public class TestConditional {
	@Test
	public void testConditional(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConditionConfiguration.class);
		try {
			Door ms = ac.getBean(Door.class);
			System.out.println(ms);
		} catch (BeansException e) {
			e.printStackTrace();
		}
		try {
			Desk desk = ac.getBean(Desk.class);
			System.out.println(desk);
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}


}
