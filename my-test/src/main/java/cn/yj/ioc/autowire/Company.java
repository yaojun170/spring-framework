package cn.yj.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-28
 */
public class Company {
	private Employee employee;
	private String name;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company{" +
				"employee=" + employee +
				", name='" + name + '\'' +
				'}';
	}
}
