package cn.yj.extension.beanfactorypostprocessor;

import cn.yj.demo.Animal;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-05
 */
public class MyHouse {
	private String location;
	private int size;
	private Animal animal;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "MyHouse{" +
				"location='" + location + '\'' +
				", size=" + size +
				", animal=" + animal +
				'}';
	}

	public void myinit(){
		System.out.println("--MyHouse--myinit--");
	}
}
