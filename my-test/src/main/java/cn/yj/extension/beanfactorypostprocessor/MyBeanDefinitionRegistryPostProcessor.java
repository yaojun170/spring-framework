package cn.yj.extension.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("--MyBeanDefinitionRegistryPostProcessor--postProcessBeanFactory()-");
		BeanDefinition myHouse = beanFactory.getBeanDefinition("myHouse");
		myHouse.getPropertyValues().add("location","LOS angelas");
		myHouse.getPropertyValues().add("size",156);
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("--MyBeanDefinitionRegistryPostProcessor--postProcessBeanDefinitionRegistry()-");
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MyHouse.class)
				.addPropertyReference("animal", "animal")
				.addPropertyValue("location", "New York")
				.setScope(BeanDefinition.SCOPE_SINGLETON)
				.setInitMethodName("myinit").getBeanDefinition();
		registry.registerBeanDefinition("myHouse", beanDefinition);
	}
}
