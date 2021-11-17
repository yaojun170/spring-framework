package cn.yj.ioc.annotion.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-12
 */
@Service
@DependsOn
public class FooServiceImpl implements FooService{
	@Override
	public void hell() {
		System.out.println("--FooServiceImpl hello--");
	}
}
