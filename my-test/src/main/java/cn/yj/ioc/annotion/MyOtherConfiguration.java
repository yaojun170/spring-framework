package cn.yj.ioc.annotion;

import cn.yj.ioc.factorybean.Desk;
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
	@Bean
	public Desk desk(){
		Desk desk = new Desk();
		return desk;
	}
}
