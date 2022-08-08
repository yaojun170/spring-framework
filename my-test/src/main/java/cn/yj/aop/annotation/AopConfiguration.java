package cn.yj.aop.annotation;

import cn.yj.aop.service.DogTool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {
	@Bean
	public DogTool dogtool(){
		DogTool dogTool = new DogTool();
		return dogTool;
	}

	@Bean
	public MyAnnotationAspect myannotationAspect(){
		return new MyAnnotationAspect();
	}
}
