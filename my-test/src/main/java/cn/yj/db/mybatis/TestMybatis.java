package cn.yj.db.mybatis;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.JoinPoint;
import org.junit.Test;

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
		/*User newUser = new User();
		newUser.setAge(60);
		newUser.setName("李连杰");
		newUser.setSex("male");
		um.addUser(newUser);*/
	}

}
