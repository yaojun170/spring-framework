package cn.yj.ioc.annotion.po;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-17
 */
public class BeanOne implements InitializingBean {
	public void initm(){
		System.out.println("--BeanOne initm()--");
	}

	public void cleanup(){
		System.out.println("--BeanOne destroy()-----");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("===BeanOne afterPropertiesSet()===");
	}
}
