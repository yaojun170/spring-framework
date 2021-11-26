package cn.yj.mysql.jdbc2;

import cn.yj.mysql.jdbc1.TestJdbc;
import cn.yj.mysql.jdbc2.po.User;
import cn.yj.mysql.jdbc2.po.UserRowMapper;
import com.mysql.jdbc.Driver;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
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

	@Test
	public void testUpdateWithTransaction(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(TestJdbc.jdbcUrl);
		dataSource.setUsername(TestJdbc.userName);
		dataSource.setPassword(TestJdbc.pwd);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);

		DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
		txDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		//获取一个事务
		TransactionStatus txStatus = txManager.getTransaction(txDefinition);

		System.out.println("-开始--");
		try {
			String sql = "insert into user(name, age, sex) values (?,?,?)";
			jdbcTemplate.update(sql, "tony stark", 49, "male");

			String sql2_maxId = "select max(id) from user";
			Integer userId = jdbcTemplate.queryForObject(sql2_maxId, int.class);
			System.out.println("maxId="+userId);

			String article="iron man要来了";

			if(!article.isEmpty()){
				throw new RuntimeException("test excep");
			}

			String sql3 = "insert into user_article(user_id,title,post_time) values(?,?, now())";
			jdbcTemplate.update(sql3, userId, article);
			txManager.commit(txStatus);
			System.out.println("-成功结束--");
		} catch (DataAccessException e) {
			e.printStackTrace();
			txManager.rollback(txStatus);
			System.err.println("-失败回滚--");
		}
	}

	@Test
	public void testTransactionTemplate(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(TestJdbc.jdbcUrl);
		dataSource.setUsername(TestJdbc.userName);
		dataSource.setPassword(TestJdbc.pwd);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource);

		TransactionTemplate tt = new TransactionTemplate(txManager);
		tt.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// 设置事务的隔离级别,设置为读已提交（默认是ISOLATION_DEFAULT:使用的是底层数据库的默认的隔离级别）
		tt.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
//		tt.setReadOnly(true);// 设置是否只读，默认是false
		// 默认使用的是数据库底层的默认的事务的超时时间
		tt.setTimeout(30000);

		Integer result = tt.execute((txStatus) -> {
			String sql = "insert into user(name, age, sex) values (?,?,?)";
			jdbcTemplate.update(sql, "spider man", 43, "male");

			String sql2_maxId = "select max(id) from user";
			Integer userId = jdbcTemplate.queryForObject(sql2_maxId, int.class);
			System.out.println("maxId=" + userId);

			String article = "no ways to go";

			/*if(!article.isEmpty()){
				System.out.println("异常发送");
				throw new RuntimeException("test excep");
			}*/

			String sql3 = "insert into user_article(user_id,title,post_time) values(?,?, now())";
			jdbcTemplate.update(sql3, userId, article);
			System.out.println("-成功结束--");
			return userId;
		});
		System.out.println("返回："+result);
	}

}
