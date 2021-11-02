package cn.yj.ioc.factorybean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-01
 */
public class MyFacotryBean extends AbstractFactoryBean<String> {
	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	protected String createInstance() throws Exception {
		return null;
	}
}
