package cn.yj.demo;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-26
 */
public class Animal {
	private String name;
	private int legs;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", legs=" + legs +
				", address='" + address + '\'' +
				'}';
	}
}
