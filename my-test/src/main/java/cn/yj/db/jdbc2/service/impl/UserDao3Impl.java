package cn.yj.db.jdbc2.service.impl;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.service.UserDao2;
import cn.yj.db.jdbc2.service.UserDao3;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public class UserDao3Impl implements UserDao3 {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	@Override
	public void insertUserAndArticle(User user, String article) {
		System.out.println("--insertUserAndArticle start---"+user+",article="+article);

		String sql = "insert into user(name, age, sex) values (?,?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSex());

		String sql2 = "select max(id) from user";
		Integer userId = jdbcTemplate.queryForObject(sql2, int.class);
		System.out.println("maxId="+userId);

		if(!article.isEmpty()){
			throw new RuntimeException("test excep");
		}

		String sql3 = "insert into user_article(user_id,title,post_time) values(?,?, now())";
		jdbcTemplate.update(sql3, userId,article);

		System.out.println("--insertUserAndArticle ok---");
	}

}
