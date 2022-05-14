package cn.yj.db.mybatis.service;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.po.UserArticle;
import cn.yj.db.mybatis.mapper.UserArticleMapper;
import cn.yj.db.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-12-08
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserArticleMapper userArticleMapper;

	@Override
	public List<User> queryUsers() {
		return userMapper.queryUsers();
	}

	@Transactional
	@Override
	public void addUser(User user, String article) {
		userMapper.addUser(user);
		System.out.println("--add user ok--");
		System.out.println("==userId=="+user.getId());
		/*if(article!=null){
			throw new RuntimeException("test exception");
		}*/
		UserArticle userArticle = new UserArticle();
		userArticle.setUserId(user.getId());
		userArticle.setTitle(article);
		userArticle.setPostTime("2021-12-08 20:00:00");
		userArticle.setShowCount(0);
		userArticle.setLikeCount(0);
		userArticle.setForwardCount(0);
		userArticleMapper.addArticle(userArticle);
		System.out.println("--add user article ok--");
	}
}
