package cn.yj.extension.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-09
 */
public class HelloSmartLifeCycle implements SmartLifecycle {
	private boolean running = false;
	@Override
	public void start() {
		System.out.println("==HelloSmartLifeCycle=start==");
		running = true;
	}

	@Override
	public void stop() {
		System.out.println("==HelloSmartLifeCycle=stop==");
		running = false;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public int getPhase() {
		return 2;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("==HelloSmartLifeCycle=stop=runnable=");
		callback.run();
	}
}
