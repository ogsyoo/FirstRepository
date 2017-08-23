package com.gsy.string;

public class MyString {
	
	
	public static void main(String[] args) {
		String str = "asdfghjkl";
		String reverseStr = reverse(str);
		System.out.println(reverseStr);
	}
	
	
	
	
	
	//反转字符串
	public static String reverse(String str){
		if(str.length()<=1||str==null){
			return str;
		}else{
			System.out.println(str.substring(1));
			return reverse(str.substring(1))+str.charAt(0);
		}
	}
}
