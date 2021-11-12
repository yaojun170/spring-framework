package cn.yj.ioc.annotion.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
@Service
public class UserServiceImpl implements UserService {
	@Override
	public String queryName(int idCard) {
		System.out.println("----UserServiceImpl queryName----"+idCard);
		return "xiaowang:"+idCard;
	}

	@Override
	public int insertUser(String userName) {
		System.out.println("----UserServiceImpl insertUser----"+userName);
		return 5;
	}
}
