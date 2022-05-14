package cn.yj.db.jdbc2.service.impl;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.service.UserDao4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
@Service
public class UserDao4Impl implements UserDao4 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public void insertUserAndArticle(User user, String article) {
		System.out.println("--addUserAndArticle start---"+user+",article="+article);
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
			@Override
			public void beforeCommit(boolean readOnly) {
				System.out.println("--beforeCommit----");
			}

			@Override
			public void beforeCompletion() {
				System.out.println("---beforeCompletion----");
			}

			@Override
			public void afterCommit() {
				System.out.println("---afterCommit()---");
			}

			@Override
			public void afterCompletion(int status) {
				System.out.println("---afterCompletion----"+status);
			}
		});

		String sql = "insert into user(name, age, sex) values (?,?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSex());

		String sql2 = "select max(id) from user";
		Integer userId = jdbcTemplate.queryForObject(sql2, int.class);
		System.out.println("maxId="+userId);

		/*if(!article.isEmpty()){
			throw new RuntimeException("test excep");
		}*/

		String sql3 = "insert into user_article(user_id,title,post_time) values(?,?, now())";
		jdbcTemplate.update(sql3, userId,article);

		System.out.println("--insertUserAndArticle ok---");
	}

}
