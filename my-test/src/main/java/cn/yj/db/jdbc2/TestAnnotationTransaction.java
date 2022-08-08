package cn.yj.db.jdbc2;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.service.UserDao4;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-29
 */
public class TestAnnotationTransaction {
	@Test
	public void testEnableTransaction(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyTransactionConfiguration.class);
		UserDao4 ud4 = ac.getBean(UserDao4.class);
		User newUser = new User();
		newUser.setAge(35);
		newUser.setName("张艺谋");
		newUser.setSex("male");
		String article = "满城尽带黄金甲";
		ud4.insertUserAndArticle(newUser,article);
	}

	@Test
	public void testTransactionWithSynchronzation(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyTransactionConfiguration.class);
		UserDao4 ud4 = ac.getBean(UserDao4.class);
		User newUser = new User();
		newUser.setAge(25);
		newUser.setName("韩磊");
		newUser.setSex("male");
		String article = "韩磊在黎姿豪宅家宴上唱歌";
		ud4.insertUserAndArticle(newUser,article);
	}
}
