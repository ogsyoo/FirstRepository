package com.gsy.templete;

public class TempleteImpl {
	private String session = "session";
	public void test (Templete tel){
		System.out.println("do something first");
		System.out.println(session);
		tel.doSomething(session);
		System.out.println("do something end");
	}
}
