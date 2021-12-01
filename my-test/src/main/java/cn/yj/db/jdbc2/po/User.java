package cn.yj.db.jdbc2.po;

import java.io.Serializable;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-17
 */
public class User implements Serializable {
    private static final long serialVersionUID = 3109858075124214818L;

    private int id;
    private String name;
    private int age;
    private String sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				'}';
	}
}
