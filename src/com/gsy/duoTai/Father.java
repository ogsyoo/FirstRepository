package com.gsy.duoTai;

public abstract class Father {
	private String fatherId = "fatherId";
	private String fatherName = "fatherName";

	static final String ABC_URL = "";

	public void getFatherMsg() {
		System.out.println("fatherId:" + fatherId + "  fatherName:" + fatherName);
	}

	public void overWriter() {
		System.out.println("我是父类我要被重写");
	}

	public int test() {
		System.out.println("返回类型");
		return 1;
	}
}
