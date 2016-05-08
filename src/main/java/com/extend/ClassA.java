package com.extend;

public class ClassA {
	private String name ;
	public ClassA(){
		System.out.println("create1 A");
	}
	public ClassA(String name){
		this.name = name;
		System.out.println("create2 A , name="+name);
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
