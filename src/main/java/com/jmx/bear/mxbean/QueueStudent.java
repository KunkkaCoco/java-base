package com.jmx.bear.mxbean;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStudent implements QueueStudentMXBean {

	private Queue<String> queue;

	public QueueStudent(Queue<String> queue) {
		this.queue = queue;
	}

	@Override
	public Student getStudent() {
		synchronized (queue) {
			return new Student(new Date(), queue.size(), queue.peek());
		}
	}

	@Override
	public void clearQueue() {
		synchronized (queue) {
			queue.clear();
		}
	}

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<String>();
		queue.offer("Hello");
		queue.offer("World!");
		queue.offer("你好！");
		System.out.println(queue.size());
		String str;
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		/*
		 * while((str=queue.poll())!=null){
		 * System.out.println(str);
		 * }
		 * System.out.println();
		 * System.out.println(queue.size());
		 * 
		 * }
		 */

	}

}
