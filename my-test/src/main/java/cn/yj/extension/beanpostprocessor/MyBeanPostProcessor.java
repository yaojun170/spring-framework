package cn.yj.extension.beanpostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-08
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("---MyBeanPostProcessor--before-"+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info("---MyBeanPostProcessor--after-"+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
