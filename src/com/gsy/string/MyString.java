package com.gsy.string;

public class MyString  {
	
	
	public static void main(String[] args) {
		String str = "asdfghjkl";
		String reverseStr = reverseStr(str);
		System.out.println(reverseStr);
	}
	
	
	//普通方法
	public static String reverseStr(String str) {
		char[] charArray = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		String index = "";
		for(int i = charArray.length;i>0;i--) {
			char charAt = str.charAt(i-1);
//			System.out.print(charAt);
			sb.append(charAt);
		}
		return sb.toString();
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
