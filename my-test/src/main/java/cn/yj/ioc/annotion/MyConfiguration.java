package cn.yj.ioc.annotion;

import cn.yj.demo.Animal;
import cn.yj.ioc.autowire.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
@EnableAsync
@ComponentScan("cn.yj.ioc.annotion.service")
@Configuration
@Import(MyOtherConfiguration.class)
public class MyConfiguration {
	@Bean
	public Employee hahaEmp(){
		Employee emp = new Employee();
		emp.setName("elon musk");
		emp.setId(87889);
		return emp;
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);//配置核心线程数
		executor.setMaxPoolSize(5);//配置最大线程数
		executor.setKeepAliveSeconds(10);
		executor.setQueueCapacity(5);//配置队列大小
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("my-custom-threadpool-");
//		executor.initialize();//执行初始化
		return executor;
	}
}
