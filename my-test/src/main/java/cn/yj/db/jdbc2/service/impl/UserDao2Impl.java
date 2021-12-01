package cn.yj.db.jdbc2.service.impl;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.service.UserDao2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public class UserDao2Impl implements UserDao2 {
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;

	@Override
	public void insertUserAndArticle(User user, String article) {
		System.out.println("--insertUserAndArticle start---"+user+",article="+article);

		DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
		txDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus transaction = transactionManager.getTransaction(txDefinition);
		try {
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
			transactionManager.commit(transaction);
		} catch (DataAccessException e) {
			e.printStackTrace();
			transactionManager.rollback(transaction);
		}

		System.out.println("--insertUserAndArticle complete---");
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager){
		this.transactionManager = transactionManager;
	}
}
