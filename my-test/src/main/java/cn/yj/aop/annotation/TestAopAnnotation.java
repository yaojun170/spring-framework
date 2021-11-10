package cn.yj.aop.annotation;

import cn.yj.aop.service.DogTool;
import cn.yj.aop.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class TestAopAnnotation {
	@Test
	public void testAnnotation(){
		System.out.println("---sss--");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/bean-aop-annotation.xml");
		DogTool dt = context.getBean("dog", DogTool.class);
		try {
			System.out.println("返回："+dt.eat("bone"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


}
