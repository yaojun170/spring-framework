package cn.yj.ioc.annotion;

import cn.yj.demo.Door;
import cn.yj.ioc.factorybean.Desk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
@Configuration
public class MyConditionConfiguration {
	/**
	 * 系统是mac加载Door
	 * 系统是windows加载Desk
	 */

	@Conditional(MyMacCondition.class)
	@Bean
	public Door door(){
		return new Door();
	}

	@Conditional(MyWindowsCondition.class)
	@Bean
	public Desk desk(){
		Desk desk = new Desk();
		return desk;
	}
}
