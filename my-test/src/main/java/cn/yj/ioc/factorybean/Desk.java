package cn.yj.ioc.factorybean;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-01
 */
public class Desk implements Furniture{
	@Override
	public void move() {
		System.out.println("===桌子==");
	}
}
