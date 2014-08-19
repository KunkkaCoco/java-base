package com.jmx.bear.mxbean;

import java.beans.ConstructorProperties;
import java.util.Date;

public class Student {

	private Date date;
	private int size;
	private String head;

	@ConstructorProperties({ "date", "size", "head" })
	public Student(Date date, int size, String head) {
		this.date = date;
		this.size = size;
		this.head = head;
	}

	public Date getDate() {
		return date;
	}

	public int getSize() {
		return size;
	}

	public String getHead() {
		return head;
	}

}
