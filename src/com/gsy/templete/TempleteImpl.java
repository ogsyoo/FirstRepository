package com.gsy.templete;

public class TempleteImpl {
	private String session = "session";
	public void test (Templete tel){
		System.out.println("do something first");
		Thread t = new Thread(new MyFirstThread(tel,"1"));
		t.start();
		Thread t1 = new Thread(new MyFirstThread(tel,"2"));
		t1.start();
		Thread t2 = new Thread(new MyFirstThread(tel,"3"));
		t2.start();
		System.out.println("do something end");
	}
}
