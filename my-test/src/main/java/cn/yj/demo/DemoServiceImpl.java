package cn.yj.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-10-26
 */
public class DemoServiceImpl implements DemoService {
	Logger logger = LoggerFactory.getLogger(TestBeanStart.class);
	@Override
	public String sayDemo() {
		logger.info("-----sayDemo----");
		return "hello Demo";
	}
}
