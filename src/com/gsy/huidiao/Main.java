package com.gsy.huidiao;

public class Main {
	public static void main(String[] args) {
		MyService myService = new MyService();
		BWriteCall bWriteCall = new BWriteCall();
		myService.setCallFunc(bWriteCall);
		myService.caozuo();
	}
}
