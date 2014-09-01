package lmax.disruptor.demo;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class TestEventProducerWithTranslator {
	// 一个translator可以看做一个事件初始化器，publicEvent方法会调用它
	// 填充Event
	private static final EventTranslatorOneArg<TestEvent, String> TRANSLATOR = new EventTranslatorOneArg<TestEvent, String>() {
		@Override
		public void translateTo(TestEvent event, long sequence, String name) {
			event.setName(name);
		}
	};
	private final RingBuffer<TestEvent> ringBuffer;

	public TestEventProducerWithTranslator(RingBuffer<TestEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void say(String name) {
		ringBuffer.publishEvent(TRANSLATOR, name);
	}
}
