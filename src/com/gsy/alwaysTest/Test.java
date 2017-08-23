package com.gsy.alwaysTest;

public class Test{
	public static void main(String[] args) {
		for(int i = 0;i<10;i++){
			a:for(int j = 0;j<5;j++){
				for(int r = 0;r<5;r++){
					System.out.println("123");
					break a;
				}
			}
		}
	}
}
