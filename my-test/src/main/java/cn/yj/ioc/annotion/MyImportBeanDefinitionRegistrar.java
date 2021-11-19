package cn.yj.ioc.annotion;

import cn.yj.ioc.annotion.po.BeanTwo;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(BeanTwo.class);
		registry.registerBeanDefinition("beanTwo",beanDefinitionBuilder.getBeanDefinition());
	}
}
