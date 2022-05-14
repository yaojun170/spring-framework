package cn.yj.ioc.annotion.service.impl;


import cn.yj.ioc.annotion.service.FooService;
import cn.yj.ioc.annotion.service.UserService;
import cn.yj.ioc.autowire.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-10
 */
@Component
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public String queryName(int idCard) {
		logger.info("----UserServiceImpl queryName----"+idCard);
		return "xiaowang:"+idCard;
	}

	@Override
	public int insertUser(String userName) {
		logger.info("----UserServiceImpl insertUser----"+userName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("----UserServiceImpl insertUser----complete");
		return 5;
	}
}
