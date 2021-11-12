package cn.yj.aop.loop2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-12
 */
@Service
public class Foo {
	@Autowired
	private Bar bar;

	public void hello(){
		System.out.println("--Foo hello--");
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
}
