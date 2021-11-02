package cn.yj.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-28
 */
public class Company {
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Company{" +
				"emp=" + employee +
				'}';
	}
}
