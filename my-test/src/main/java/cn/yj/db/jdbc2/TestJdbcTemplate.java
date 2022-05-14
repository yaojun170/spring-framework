package cn.yj.db.jdbc2;

import cn.yj.db.jdbc1.TestJdbc;
import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.po.UserRowMapper;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public class TestJdbcTemplate {
	/**
	 * 测试spring-JDBC-基础用法操作数据库
	 */
	@Test
	public void testQuery(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();//SimpleDriverDataSource没有使用连接池
//		dataSource.setDriverClass(Driver.class);
		dataSource.setUrl(TestJdbc.jdbcUrl);
		dataSource.setUsername(TestJdbc.userName);
		dataSource.setPassword(TestJdbc.pwd);


		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from user";
		List<User> userList = jdbcTemplate.query(sql, new UserRowMapper());
		System.out.println("userList:"+userList);

		String s = jdbcTemplate.queryForObject("select name from user where id=?", String.class, 3);
		System.out.println("result:"+s);
	}

	@Test
	public void testUpdate(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(TestJdbc.jdbcUrl);
		dataSource.setUsername(TestJdbc.userName);
		dataSource.setPassword(TestJdbc.pwd);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int update = jdbcTemplate.update("update user set age=age+1 where id>?", 5);
		System.out.println("影响条数："+update);
	}

}
