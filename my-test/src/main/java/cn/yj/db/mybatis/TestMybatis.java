package cn.yj.db.mybatis;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.po.UserArticle;
import cn.yj.db.mybatis.mapper.UserArticleMapper;
import cn.yj.db.mybatis.mapper.UserMapper;
import cn.yj.db.mybatis.mapper.UserTestMapper;
import cn.yj.db.mybatis.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-28
 */
public class TestMybatis {
	@Test
	public void testMybatis() throws Exception{
		String resource = "mybatis/mybatis-config.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		UserMapper um2 = sqlSession.getMapper(UserMapper.class);
		System.out.println(um);
		System.out.println(um2);
		List<User> users = um.queryUsers();
		System.out.println(users);
		System.out.println("----update--");
//		List<Object> objects = sqlSession.selectList("queryUsers");
//		System.out.println(objects);
		/*User newUser = new User();
		newUser.setAge(60);
		newUser.setName("李连杰");
		newUser.setSex("male");
		um.addUser(newUser);*/
	}

	@Test
	public void testMybatisWithSpring(){
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("mybatis/mybatis-notransaction.xml");
		UserMapper um = appCtx.getBean(UserMapper.class);
		System.out.println("-----");
		List<User> users = um.queryUsers();
		users.forEach((useri -> System.out.println(useri)));
		System.out.println("-------");
		UserArticleMapper uam = appCtx.getBean(UserArticleMapper.class);
		UserArticle userArticle = uam.queryArticleByUserId(28);
		System.out.println(userArticle);
		System.out.println("========");
		UserTestMapper utm = appCtx.getBean(UserTestMapper.class);
		utm.queryList();
		/*UserArticle newArticle = new UserArticle();
		newArticle.setUserId(3);
		newArticle.setForwardCount(5);
		newArticle.setLikeCount(500);
		newArticle.setTitle("纸钞屋第5季");
		newArticle.setPostTime("2021-09-01 09:00:00");
		newArticle.setShowCount(30000);
		uam.addArticle(newArticle);*/
	}

	@Test
	public void testMybatisWithSpringAndTransactional(){
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("mybatis/mybatis-transaction.xml");
		UserService us = appCtx.getBean(UserService.class);
		User newUser = new User();
		newUser.setAge(70);
		newUser.setName("发改委");
		newUser.setSex("female");
		String title = "国家发改委印发沪苏浙一对一帮扶皖北8市方案";
		us.addUser(newUser, title);
	}

}
