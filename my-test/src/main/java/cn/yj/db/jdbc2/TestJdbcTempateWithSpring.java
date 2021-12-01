package cn.yj.db.jdbc2;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.service.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public class TestJdbcTempateWithSpring {
	@Test
	public void test1(){
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("jdbc/appContext-jdbc-01.xml");
		UserDao us = appCtx.getBean(UserDao.class);
		/*User newUser = new User();
		newUser.setAge(58);
		newUser.setName("steven job");
		newUser.setSex("male");
		newUser.setId(8);
		us.updateUserById(newUser);*/
		List<User> users = us.queryUsers();
		System.out.println(users);
	}
}
