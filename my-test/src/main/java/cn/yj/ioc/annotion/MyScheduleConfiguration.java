package cn.yj.ioc.annotion;

import cn.yj.ioc.annotion.service.UserService;
import cn.yj.ioc.annotion.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@EnableScheduling
@Configurable
public class MyScheduleConfiguration {
	Logger logger = LoggerFactory.getLogger(MyScheduleConfiguration.class);

	@Scheduled(fixedRate = 1000*5)
	public void runWithRate(){
		logger.info(new Date()+"====>schedule run....");
	}

	@Scheduled(cron = "*/7 * * * * ?")
	public void runwithCron(){
		logger.info(new Date()+"====>schedule cron....");
	}
}
