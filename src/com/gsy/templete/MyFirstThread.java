package com.gsy.templete;

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
	Templete tel;
	String id;

	public MyFirstThread(Templete tel, String id) {
		this.tel = tel;
		this.id = id;
	}
	int j = 0;
	@Override
	public void run() {
		while(j++<10) {
			System.out.println(id);
			tel.doSomething("gsy");
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
