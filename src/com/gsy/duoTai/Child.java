package com.gsy.duoTai;

public class Child extends Father{
	
	private  String fatherName = "changeFatherName";
	
	public void overWriter(){
		System.out.println("我是子类我重写了");
	}
	
	public void addMethod(){
		System.out.println("我是新增的方法");
	}
}
