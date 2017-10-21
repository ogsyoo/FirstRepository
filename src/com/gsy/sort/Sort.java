package com.gsy.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sort {
	public static void main(String[] args) {
		Integer[] testArray = getAroungArray();
		// insetSort(getAroungArray());
		// maoPaoSort(getAroungArray());
		Integer[] arr = quickSort(testArray, 0, testArray.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	// 插入排序   将要排序的数据插入到有序的顺序中     时间复杂度：O（n^2）
	public static void insetSort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				int temp = array[i];
				int j = i;
				while (j > 0 && array[j - 1] > temp) {
					array[j] = array[j - 1];
					j--;
				}
				array[j] = temp;
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// 冒泡排序
	public static void maoPaoSort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// 快速排序 4 2 5 6 3 7 9 1   O(nlog2n)
	public static Integer[] quickSort(Integer[] arr, int _left, int _right) {
		int left = _left;
		int right = _right;
		int temp = 0;
		if (left <= right) { // 待排序的元素至少有两个的情况
			temp = arr[left]; // 待排序的第一个元素作为基准元素
			while (left != right) { // 从左右两边交替扫描，直到left = right
				while (right > left && arr[right] >= temp)
					right--; // 从右往左扫描，找到第一个比基准元素小的元素
				arr[left] = arr[right]; // 找到这种元素arr[right]后与arr[left]交换
				while (left < right && arr[left] <= temp)
					left++; // 从左往右扫描，找到第一个比基准元素大的元素
				arr[right] = arr[left]; // 找到这种元素arr[left]后，与arr[right]交换
			}
			arr[right] = temp; // 基准元素归位
			quickSort(arr, _left, left - 1); // 对基准元素左边的元素进行递归排序
			quickSort(arr, right + 1, _right); // 对基准元素右边的进行递归排序
		}
		return arr;
	}

	// 随机产生一组数组并显示
	public static Integer[] getAroungArray() {
		List<Integer> set = new ArrayList<>();
		int len = 0;
		while (len < 10) {
			int a = (int) (Math.random() * 30);
			if (!set.contains(a))
				set.add(a);
			len = set.size();
		}
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("----------------------------------");
		return set.toArray(new Integer[set.size()]);
	}
}
