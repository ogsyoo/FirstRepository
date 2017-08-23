package com.gsy.duoTai;

public class Father {
	private String fatherId = "fatherId";
	private String fatherName = "fatherName";

	public void getFatherMsg() {
		System.out.println("fatherId:" + fatherId + "  fatherName:" + fatherName);
	}

	public void overWriter() {
		System.out.println("我是父类我要被重写");
	}
}
