package com.gsy.string;

public class SortString {
	public static void main(String[] args) {
		sort("abcde");

	}

	public static void sort(String str) {
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++) {
			// abcd
			if (i > 0) {
				char temp = array[i];
				array[i] = array[0];
				array[0] = temp;
			}
			System.out.println("以" + array[0] + "为首字母的排序：");
			System.out.println(array);
			char[] array1;
			for (int j = 1; j < array.length; j++) {
				for (int p = j + 1; p < array.length; p++) {
					array1 = array.clone();
					char temp1 = array1[j];
					array1[j] = array1[p];
					array1[p] = temp1;
					System.out.print(array1);
					System.out.println(" ");
				}
			}
		}
	}
}
