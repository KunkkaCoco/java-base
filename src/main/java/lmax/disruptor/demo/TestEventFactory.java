package lmax.disruptor.demo;

import com.lmax.disruptor.EventFactory;

public class TestEventFactory implements EventFactory<TestEvent> {

	@Override
	public TestEvent newInstance() {
		TestEvent te = new TestEvent();
		te.setName("my name");
		return new TestEvent();
	}

}
