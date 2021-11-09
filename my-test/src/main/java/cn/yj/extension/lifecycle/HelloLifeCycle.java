package cn.yj.extension.lifecycle;

import org.springframework.context.Lifecycle;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-09
 */
public class HelloLifeCycle implements Lifecycle {
	boolean running=false;
	@Override
	public void start() {
		System.out.println("--HelloLifeCycle-start-");
		running = true;
	}

	@Override
	public void stop() {
		System.out.println("--HelloLifeCycle-stop-");
		running = false;
	}

	@Override
	public boolean isRunning() {
		return running;
	}
}
