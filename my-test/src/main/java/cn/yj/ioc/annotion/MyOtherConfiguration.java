package cn.yj.ioc.annotion;

import cn.yj.demo.Door;
import cn.yj.demo.Room;
import cn.yj.ioc.factorybean.Desk;
import cn.yj.ioc.initdestory.Car;
import org.springframework.context.annotation.*;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-16
 */
@Configuration
@PropertySource("classpath:config.properties")
@ImportResource("classpath:demo/bean-demo.xml")
public class MyOtherConfiguration {
	//思考：下面Desk在创建Bean的过程中以及和room()创建Room的过程中是否会重复执行desk()方法？

	@Bean
	public Room room(Desk desk, Door door){
		Room room = new Room(desk, door);
		room.setAddress("beijing changping tiantongyuan");
		return room;
	}

	@Bean
	public Desk desk(){
		Desk desk = new Desk();
		return desk;
	}

	@Bean
	public Door door(){
		return new Door();
	}

	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	public Car car(){
		Car car = new Car();
		car.setBrand("tesla");
		car.setCountry("USA");
		car.setWeight(1000);
		car.setYear(2020);
		return car;
	}
}
