package cn.yj.aop.service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
public interface UserService {
	String queryName(int idCard);

	int insertUser(String userName);
}
