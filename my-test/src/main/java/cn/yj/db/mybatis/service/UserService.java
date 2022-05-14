package cn.yj.db.mybatis.service;

import cn.yj.db.jdbc2.po.User;

import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-12-08
 */
public interface UserService {
	List<User> queryUsers();

	void addUser(User user, String article);
}
