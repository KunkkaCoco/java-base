package lmax.disruptor.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class TestEventMain {
	public static void main(String[] args) throws InterruptedException {

		Executor executor = Executors.newCachedThreadPool();

		TestEventFactory factory = new TestEventFactory();

		int bufferSize = 1024;

		Disruptor<TestEvent> disruptor = new Disruptor<TestEvent>(factory, bufferSize, executor);

		disruptor.handleEventsWith(new TestEventHandler());

		disruptor.start();

		RingBuffer<TestEvent> ringBuffer = disruptor.getRingBuffer();

		TestEventProducerWithTranslator producer = new TestEventProducerWithTranslator(ringBuffer);

		for (long l = 0; l < 20; l++) {
			producer.say("pony");
		}
	}
}
