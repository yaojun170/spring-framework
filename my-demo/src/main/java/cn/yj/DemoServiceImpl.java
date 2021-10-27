package cn.yj;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-26
 */
public class DemoServiceImpl implements DemoService {
	@Override
	public String sayDemo() {
		System.out.println("-----sayDemo----");
		return "hello Demo";
	}
}
