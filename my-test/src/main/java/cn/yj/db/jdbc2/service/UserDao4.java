package cn.yj.db.jdbc2.service;

import cn.yj.db.jdbc2.po.User;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public interface UserDao4 {

	void insertUserAndArticle(User user, String article);
}
