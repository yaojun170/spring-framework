package cn.yj.mysql.jdbc2;

import cn.yj.mysql.jdbc2.po.User;
import cn.yj.mysql.jdbc2.po.UserArticle;
import cn.yj.mysql.jdbc2.service.UserDao;
import cn.yj.mysql.jdbc2.service.UserDao2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public class TestJdbcTempateWithSpringTransaction {
	@Test
	public void testJdbcTransaction(){
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("jdbc/appContext-jdbc-02.xml");
		UserDao2 us = appCtx.getBean(UserDao2.class);

		User newUser = new User();
		newUser.setAge(58);
		newUser.setName("steven job");
		newUser.setSex("male");
		newUser.setId(8);

		String article = "党的二十大2022年在北京召开";
		us.insertUserAndArticle(newUser, article);
	}
}
