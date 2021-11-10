package cn.yj.aop.xml;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class XmlAspect {
	public void before() {
		System.out.println(">>>>>>before ......");
	}

	public void after() {
		System.out.println(">>>>>>after ......");
	}

	public void afterThrowing() {
		System.out.println(">>>>>>after-throwing ......");
	}

	public void afterReturning() {
		System.out.println(">>>>>>>>>after-returning ......");
	}
}
