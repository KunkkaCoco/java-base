package com.extend;

public class ClassB extends ClassA {
	private int age ;
	public ClassB(){
		System.out.println("create1 ClassB");
	}
	public ClassB(int age){
		this.age = age;
		System.out.println("create2 B , age="+age);
	}public ClassB(int age,String name){
		super(name);
		this.age = age;
		System.out.println("create3 B , age="+age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
