package cn.yj.ioc.initdestory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-09
 */
public class Car implements InitializingBean, DisposableBean {
	private String brand;
	private String country;
	private int weight;
	private int year;

	public Car(){
		System.out.println("**Car()***");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println(">>>>>Car populate field");
		this.brand = brand;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * bean完成后调用
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("----Car--afterPropertiesSet()-");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("----Car--DisposableBean destroy()-");
	}

	/**
	 * 注意：@PostConstruct需要配置CommonAnnotationBeanPostProcessor才能生效
	 * 或者直接开启注解才能生效<context:annotation-config />
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println("===Car: @PostConstruct====");
	}

	@PreDestroy
	public void predestory(){
		System.out.println("===Car: @PreDestroy====");
	}

	private void initMethod() {
		System.out.println("#### Car: init-method####");
	}

	private void destroyMethod(){
		System.out.println("######## Car: destroy-method####");
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				", country='" + country + '\'' +
				", weight=" + weight +
				", year=" + year +
				'}';
	}
}
