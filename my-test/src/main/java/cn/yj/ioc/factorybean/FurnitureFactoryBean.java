package cn.yj.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-01
 */
public class FurnitureFactoryBean implements FactoryBean<Furniture> {
	private String type;
	public FurnitureFactoryBean(String type){
		this.type = type;
	}

	@Override
	public Furniture getObject() throws Exception {
		if(type.equals("desk")){
			return new Desk();
		}
		if(type.equals("chair")){
			return new Chair();
		}
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		if(type.equals("desk")){
			return Desk.class;
		}
		if(type.equals("chair")){
			return Chair.class;
		}
		return null;
	}
}
