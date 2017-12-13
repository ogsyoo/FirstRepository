package com.gsy.huidiao;

public class Main {
	public static void main(String[] args) {
		System.out.println("测试eclipse提交");
		MyService myService = new MyService();
		BWriteCall bWriteCall = new BWriteCall();
		myService.setCallFunc(bWriteCall);
		myService.caozuo();
	}
}
