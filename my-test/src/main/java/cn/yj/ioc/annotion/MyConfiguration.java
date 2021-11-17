package cn.yj.ioc.annotion;

import cn.yj.demo.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
@ComponentScan("cn.yj.ioc.annotion.service")
@Configuration
@Import(MyOtherConfiguration.class)
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
