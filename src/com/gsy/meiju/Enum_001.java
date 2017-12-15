package com.gsy.meiju;

import java.util.EnumSet;

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
		EnumSet<Enum_001> weekSet = EnumSet.allOf(Enum_001.class);
		for(Enum_001 day:weekSet) {
			if(day.id==id) {
				return day;
			}
		}
		return null;
//		switch (id) {
//		case 1:
//			return Enum_001.city;
//		case 2:
//			return Enum_001.city;
//		case 3:
//			return Enum_001.city;
//		default:
//			return null;
//		}
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
