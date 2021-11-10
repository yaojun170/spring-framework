package cn.yj.aop.demo;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class Cooker {
	public String makeFood(String org){
		System.out.println("---厨师做菜中--");
		return "egg:"+org;
	}

	public void wash(){
		System.out.println("---厨师开始洗盘子--");
	}
}
