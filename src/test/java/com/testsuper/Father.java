package com.testsuper;

public class Father {
	public String v = "Father";
	public String x = "输出了Father类的public成员变量x!!!";

	public Father() {
		System.out.println("Father构造方法被调用!");
	}

	public Father(String v) {
		this.v = "Father类的带参数构造方法!运行了.";
	}

	public void outinfo() {
		System.out.println("Father的outinfo方法被调用");
	}

	public static void main(String[] args) {
		// TODO 自动生成方法存根
	}
}
