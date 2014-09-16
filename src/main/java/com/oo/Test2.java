package com.oo;


public class Test2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		D d = new D("男");
		C c = new C("张三", "20", d);
		C new_c = (C) c.clone();// 调用clone方法来赋值
		new_c.name = "李四";
		d.sex = "女";// d
		System.out.println(c.d.sex);
		System.out.println(c.name);

	}

}

class C implements Cloneable {
	String name;
	String age;
	D d;

	C(String name, String age, D d) throws CloneNotSupportedException {
		this.name = name;
		this.age = age;
		this.d = (D) d.clone();// 调用clone方法来赋值，这样即便外部的d发生变化，c里的也不会变
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

class D implements Cloneable {// 实现Cloneable接口
	String sex;

	D(String sex) {
		this.sex = sex;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
}