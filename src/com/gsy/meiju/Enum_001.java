package com.gsy.meiju;

public enum Enum_001 {
	city(1,"城市"),
	prv(2,"sheng"),
	country(3, "guo");
	
	private Enum_001(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	private int id;
	
	private String text;

	public static Enum_001 getE(int id) {
		switch (id) {
		case 1:
			return Enum_001.city;
		case 2:
			return Enum_001.city;
		case 3:
			return Enum_001.city;
		default:
			return null;
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
