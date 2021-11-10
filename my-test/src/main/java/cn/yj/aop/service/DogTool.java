package cn.yj.aop.service;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public class DogTool {
	public String eat(String food){
		System.out.println("--Dog eat start--"+food);
		if(food!=null){
//			throw new RuntimeException("test exception");
		}
		System.out.println("--Dog eat end--"+food);
		return food+":好吃!";
	}

	public void runn(){
		System.out.println("--Dog running----");
	}
}
