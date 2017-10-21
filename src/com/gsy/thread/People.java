package com.gsy.thread;

public class People {
	private String name;
	private boolean flag;
	public String getName() {
		return name;
	}
	
	public People(String name, boolean flag) {
		super();
		this.name = name;
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name:"+name+" | age: "+flag;
	}
}
