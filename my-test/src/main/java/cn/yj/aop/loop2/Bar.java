package cn.yj.aop.loop2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-12
 */
@Service
public class Bar {
	@Autowired
	private Foo foo;

	public void fuck(){
		System.out.println("---Bar fuck--");
		this.foo.hello();
	}

	public Foo getFoo() {
		return foo;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}
}
