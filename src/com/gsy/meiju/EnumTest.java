package com.gsy.meiju;

import java.util.Comparator;

public enum EnumTest{
	// MyString m1 = new MyString();
	red {
		public String color() {
			return "Color.red";
		}
	},
	blue {
		public String color() {
			return "Color.red";
		}
	};
	
	


	public String color() {
		return "color";
	}
}
