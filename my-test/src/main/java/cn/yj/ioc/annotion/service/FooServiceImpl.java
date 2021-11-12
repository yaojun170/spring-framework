package cn.yj.ioc.annotion.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-12
 */
@Service
public class FooServiceImpl implements FooService{
	@Override
	public void hell() {
		System.out.println("--FooServiceImpl hello--");
	}
}
