package cn.yj.ioc.annotion.service.impl;

import cn.yj.demo.TestBeanStart;
import cn.yj.ioc.annotion.service.MyAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
@Service
public class MyAsyncServiceImpl implements MyAsyncService {
	Logger logger = LoggerFactory.getLogger(MyAsyncServiceImpl.class);

	@Async
	@Override
	public void sendEmail(String toUser, String msg) {
		logger.info("--sendEmail--"+toUser+",msg="+msg);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("--sendEmail--complete=====");
	}

	@Async
	@Override
	public String downloadMovie(String movieUrl) {
		logger.info("--downloadMovie--start=====");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("--sendEmail--complete=====");
		return "iron man4";
	}

	@Async
	@Override
	public Future<String> downloadPic(String picUrl) {
		logger.info("--downloadMovie--start=====");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("--sendEmail--complete=====");
		return new AsyncResult<String>("idf.jpg");
	}
}
