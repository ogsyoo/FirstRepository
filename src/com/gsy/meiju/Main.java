package com.gsy.meiju;

public class Main {
	public static void main(String[] args) {
//		EnumTest[] values = EnumTest.values();
//		for (EnumTest s : values) {
//			System.out.println(s);
//		}
		
		System.out.println(EnumTest.red.compareTo(EnumTest.blue));
		
		System.out.println(EnumTest.red.color());
	}
}