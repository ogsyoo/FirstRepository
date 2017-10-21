package com.gsy.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MyFirstThread implements Runnable {
	String id;
	Object per, next;
	int count = 10;

	public MyFirstThread(String id, Object per, Object next) {
		super();
		this.id = id;
		this.per = per;
		this.next = next;
	}

	@Override
	public void run() {
		while (count > 0) {
			count--;
			synchronized (per) {
				synchronized (next) {
					System.out.println(id);
					next.notify();
					try {
						per.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	// String name;
	// boolean flag = true;
	// int id;
	// int count = 3;
	// private static int num = 0;
	// private static final Object lock = new Object();
	//
	// public MyFirstThread(String name, int id) {
	// this.name = name;
	// this.id = id;
	// }
	//
	// public void run() {
	// while (flag) {
	// synchronized (lock) {
	// if (num % count == id && num <=30) {
	// System.out.println(name);
	// num++;
	// lock.notifyAll();
	// } else if(num>30){
	// flag = false;
	// }else{
	// try {
	// lock.wait();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	// }
	//
	// }
	// }

}
