package cn.yj.ioc.annotion;

import cn.yj.demo.Animal;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
public class TestAnnotationStart {
	@Test
	public void testAnnotationStart(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Animal animal = ac.getBean("animal", Animal.class);
		System.out.println(animal);
	}
}
