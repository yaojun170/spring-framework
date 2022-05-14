package cn.yj.db.jdbc2;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.service.UserDao;
import cn.yj.db.jdbc2.service.UserDao3;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试xml配置的事务
 * @Author yaojun
 * @Date 2021-11-26
 */
public class TestXmlTransaction {
	@Test
	public void testXmlTransaction(){
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("jdbc/appContext-jdbc-transaction.xml");
		UserDao ud = appCtx.getBean(UserDao.class);
		System.out.println("-------");
		try {
			User newUser = new User();
			newUser.setAge(56);
			newUser.setName("wanggege");
			newUser.setSex("female");
			newUser.setId(24);
			ud.updateUserById(newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testXmlAutoTransaction(){
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("jdbc/appContext-jdbc-transaction-auto.xml");
		UserDao3 ud3 = appCtx.getBean(UserDao3.class);
		System.out.println("----====---");
		User newUser = new User();
		newUser.setAge(35);
		newUser.setName("刘德华");
		newUser.setSex("male");
		String article = "刘德华香港演唱会";
		ud3.insertUserAndArticle(newUser, article);
		try {
			System.out.println("--end--");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
