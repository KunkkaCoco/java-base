package lmax.disruptor.demo;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class TestEventProducer {
	private final RingBuffer<TestEvent> ringBuffer;

	private int fix = 1;

	public TestEventProducer(RingBuffer<TestEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer bb) {
		long sequence = ringBuffer.next(); // Grab the next sequence
		try {
			TestEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
														// for the sequence
			event.setValue(bb.getLong(0)); // Fill with data
		} finally {
			ringBuffer.publish(sequence);
		}
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
