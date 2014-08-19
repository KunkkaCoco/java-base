package com.testsuper;

public class Son extends Father {
	public String v = "Son";

	public Son() {
		super(); // 调用超类的构造方法,只能放到第一行.
		System.out.println("Son无参数构造方法被调用!");
		// super(); //错误的,必须放到构造方法体的最前面.
	}

	public Son(String str) {
		super(str);
		System.out.println("Son带参数构造方法被调用!");
	}

	// 覆盖了超类成员方法outinfo()
	@Override
	public void outinfo() {
		System.out.println("Son的outinfo()方法被调用");
	}

	public void test() {

		String v = "哈哈哈哈!"; // 局部变量v覆盖了成员变量v和超类变量v

		System.out.println("------1-----");
		System.out.println(v); // 输出局部变量v
		System.out.println(this.v); // 输出(子类)成员变量v
		System.out.println(super.v); // 输出超类成员变量v

		System.out.println("------2-----");
		System.out.println(x); // 输出超类成员变量x,子类继承而来
		System.out.println(super.x); // 输出超类成员变量x

		System.out.println("------3-----");
		outinfo(); // 调用子类的outinfo()方法
		this.outinfo(); // 调用子类的outinfo()方法
		super.outinfo(); // 调用父类的outinfo()方法
	}

	public static void main(String[] args) {
		new Son().test();

	}
}
