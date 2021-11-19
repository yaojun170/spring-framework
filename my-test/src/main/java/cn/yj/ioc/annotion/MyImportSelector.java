package cn.yj.ioc.annotion;

import cn.yj.ioc.annotion.po.BeanOne;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println(importingClassMetadata.getAnnotationTypes());
		return new String[]{BeanOne.class.getName()};
	}
}
