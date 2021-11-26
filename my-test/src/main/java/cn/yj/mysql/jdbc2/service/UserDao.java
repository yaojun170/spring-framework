package cn.yj.mysql.jdbc2.service;

import cn.yj.mysql.jdbc2.po.User;

import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-17
 */
public interface UserDao {
	User queryUserById(int userId);
	List<User> queryUsers();

	void save(User user);
	void deleteUser(int userId);

    void updateUserById(User user);

    //批量操作
    void batchUpdateUser(List<User> users);
}
