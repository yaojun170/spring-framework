package cn.yj.ioc.annotion;

import cn.yj.demo.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
@Configuration
public class MyConfiguration {
	@Bean(name = "animal")
	public Animal getAnimal(){
		Animal animal = new Animal();
		animal.setName("Donand Trump");
		animal.setLegs(2);
		animal.setAddress("US WC");
		return animal;
	}
}
