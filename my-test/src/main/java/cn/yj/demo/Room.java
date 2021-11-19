package cn.yj.demo;

import cn.yj.ioc.factorybean.Desk;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-17
 */
public class Room {
	private String address;
	private Desk desk;
	private Door door;
	public Room(Desk desk, Door door){
		this.desk = desk;
		this.door = door;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}
}
