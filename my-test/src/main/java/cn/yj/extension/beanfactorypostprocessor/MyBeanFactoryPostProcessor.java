package cn.yj.extension.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-04
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("--MyBeanFactoryPostProcessor--postProcessBeanFactory()-");
		BeanDefinition animalDefinition = beanFactory.getBeanDefinition("animal");
		System.out.println(animalDefinition.getBeanClassName());
		MutablePropertyValues propertyValues = animalDefinition.getPropertyValues();
		for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
			System.out.println(propertyValue.getName()+":"+propertyValue.getValue());
		}
		System.out.println("##animal定义#"+animalDefinition);
		//修改定义
		propertyValues.addPropertyValue("age", 76);
	}
}
