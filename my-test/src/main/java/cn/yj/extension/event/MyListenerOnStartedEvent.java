package cn.yj.extension.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-09
 */
public class MyListenerOnStartedEvent implements ApplicationListener<ContextStartedEvent> {
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("==MyListenerOnStartedEvent==ContextStartedEvent====");
	}
}
