package cn.yj.mysql.jdbc2.service;

import cn.yj.mysql.jdbc2.po.User;
import cn.yj.mysql.jdbc2.po.UserArticle;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-23
 */
public interface UserDao2 {

	void insertUserAndArticle(User user, String article);
}
