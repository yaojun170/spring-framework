package cn.yj.ioc.annotion.service;

import java.util.concurrent.Future;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-18
 */
public interface MyAsyncService {
	void sendEmail(String toUser,String msg);

	String downloadMovie(String movieUrl);

	Future<String> downloadPic(String picUrl);
}
