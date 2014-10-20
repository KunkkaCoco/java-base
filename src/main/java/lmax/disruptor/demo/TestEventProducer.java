package lmax.disruptor.demo;

import com.lmax.disruptor.RingBuffer;

public class TestEventProducer {
	private final RingBuffer<TestEvent> ringBuffer;

	private int fix = 1;

	public TestEventProducer(RingBuffer<TestEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void say() {
		long sequence = ringBuffer.next(); // Grab the next sequence
		try {
			TestEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
			String name = "maxi" + this.fix++; // for the sequence
			event.setName(name); // Fill with data
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
