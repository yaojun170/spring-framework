package cn.yj.ioc.annotion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSchedule {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyScheduleConfiguration.class);
	}
}
