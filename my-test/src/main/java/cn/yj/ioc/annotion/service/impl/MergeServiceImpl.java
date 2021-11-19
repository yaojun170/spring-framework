package cn.yj.ioc.annotion.service.impl;

import cn.yj.ioc.annotion.service.FooService;
import cn.yj.ioc.annotion.service.MergeService;
import cn.yj.ioc.annotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-17
 */
@Service
public class MergeServiceImpl implements MergeService {
	@Autowired
	private FooService fooService;
	@Autowired
	private UserService userService;

	@Override
	public void merge() {
		System.out.println("###MergeService merge()####");
		fooService.hell();
		System.out.println("###Return:"+userService.queryName(6789));
	}
}
