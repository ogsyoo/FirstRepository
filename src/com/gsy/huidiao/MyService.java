package com.gsy.huidiao;

public class MyService {
	MyInterface myInterface;
	//设置B程序员写的逻辑
	public void setCallFunc(MyInterface myInterface) {
		this.myInterface = myInterface;
	}
	public void caozuo() {
		System.out.println("-----A正在写东西-------");
		System.out.println("-----A需要B写东西-------");
		myInterface.getData();
		System.out.println("-------调用了B写的东西---------");
	}
}
