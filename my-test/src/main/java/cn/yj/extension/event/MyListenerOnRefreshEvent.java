package cn.yj.extension.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-09
 */
public class MyListenerOnRefreshEvent implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("==MyListenerOnRefreshEvent==ContextRefreshedEvent====");
	}
}
