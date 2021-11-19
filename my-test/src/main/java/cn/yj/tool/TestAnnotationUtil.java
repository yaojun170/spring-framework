package cn.yj.tool;

import cn.yj.ioc.annotion.MyOtherConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-17
 */
public class TestAnnotationUtil {
	@Test
	public void testAnnotationUtil(){
		//获取class上的注解
		PropertySource psAnno = AnnotationUtils.findAnnotation(MyOtherConfiguration.class, PropertySource.class);
		System.out.println(psAnno);
		System.out.println("------");
		Method carMethod = ReflectionUtils.findMethod(MyOtherConfiguration.class, "car");
		Bean beanAnno = AnnotationUtils.findAnnotation(carMethod, Bean.class);
		System.out.println(beanAnno);

		Map<String, Object> beanAnnoAttributes = AnnotationUtils.getAnnotationAttributes(beanAnno);
		System.out.println(beanAnnoAttributes);
		System.out.println("--");
	}
}
