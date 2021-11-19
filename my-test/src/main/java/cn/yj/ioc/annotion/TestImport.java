package cn.yj.ioc.annotion;

import cn.yj.demo.Door;
import cn.yj.ioc.annotion.po.BeanOne;
import cn.yj.ioc.annotion.po.BeanTwo;
import cn.yj.ioc.annotion.service.MergeService;
import cn.yj.ioc.autowire.Employee;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public class TestImport {
	@Test
	public void testImport(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyImportConfiguration.class);
		Door ms = ac.getBean(Door.class);
		System.out.println(ms);
		Employee emp = ac.getBean(Employee.class);
		System.out.println(emp);
	}

	@Test
	public void testImportSelector(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyImportConfiguration.class);
		Door ms = ac.getBean(Door.class);
		System.out.println(ms);
		BeanOne bo = ac.getBean(BeanOne.class);
		System.out.println(bo);
		System.out.println("---------");
		BeanTwo beanTwo = (BeanTwo) ac.getBean("beanTwo");
		System.out.println(beanTwo);
	}
}
