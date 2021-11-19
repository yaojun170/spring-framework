package cn.yj.ioc.annotion;

import cn.yj.demo.Door;
import cn.yj.ioc.autowire.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
@Configuration
@Import({Employee.class/*,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class*/})
public class MyImportConfiguration {
	@Bean
	public Door door(){
		return new Door();
	}
}
