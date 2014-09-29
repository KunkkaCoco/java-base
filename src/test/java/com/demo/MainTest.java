package com.demo;

public class MainTest {
	public static void main(String[] args) {
		// for (int i = 0; i < 50; i++) {
		// System.out.println((int) (Math.random() * 5));
		// }
		String a = "foo";
		String b = "foo";

		System.out.println(a == b);
		System.out.println(a.equals(b));
		String c = new String("bar");
		String d = new String("bar");

		System.out.println(c == d);
		System.out.println(c.equals(d));
	}
}