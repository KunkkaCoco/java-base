package lmax.disruptor.demo;

import com.lmax.disruptor.EventHandler;

public class TestEventHandler implements EventHandler<TestEvent> {

	@Override
	public void onEvent(TestEvent te, long paramLong, boolean paramBoolean) throws Exception {

		System.out.println(te.getName() + " says : You are my world!");

	}
}
