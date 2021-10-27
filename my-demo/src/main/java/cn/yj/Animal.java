package cn.yj;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-26
 */
public class Animal {
	private String name;
	private int legs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", legs=" + legs +
				'}';
	}
}
