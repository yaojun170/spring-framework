package cn.yj.ioc.annotion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public class MyWindowsCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		// 判断是否是Windows系统
		String property = environment.getProperty("os.name");
		if (property.contains("Windows")){
			return true;
		}
		return false;
	}
}
