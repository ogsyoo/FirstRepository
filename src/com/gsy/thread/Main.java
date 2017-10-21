package com.gsy.thread;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Thread t1 = new Thread(new MyFirstThread("A", c, a));//c w   a   no
		Thread t2 = new Thread(new MyFirstThread("B", a, b));//a no  b no   
		Thread t3 = new Thread(new MyFirstThread("C", b, c));//c w
		t1.start();
		try {
			t1.sleep(1000);
			t2.start();
			t2.sleep(1000);
			t3.start();
			t3.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// new Thread(new MyFirstThread("A", 0)).start();
		// new Thread(new MyFirstThread("B", 1)).start();
		// new Thread(new MyFirstThread("C", 2)).start();

	}

	// static Thread makeThread(final String id, boolean flag) {
	// Thread t = new Thread(id) {
	// public void run() {
	// if(flag){
	// for(int i = 0 ;i<100;i++){
	// System.out.println(id+" | "+i+ " | "+this.isAlive());
	// }
	// }else{
	// for(int i = 0 ;i<10;i++){
	// System.out.println(id+" | "+i+ " | "+this.isAlive());
	// }
	// }
	// }
	//
	// };
	// t.setDaemon(flag);
	// t.start();
	// return t;
	//
	// }

	// public static void main(String[] args) {
	// Thread t1 = makeThread("A", false);
	// Thread t2 = makeThread("B", true);
	// if(!t1.isAlive()){
	// System.out.println("t1 over");
	// }
	// if(!t2.isAlive()){
	// System.out.println("t2 over");
	// }
	// try {
	// Thread.sleep(5000);
	// System.out.println(t2.isAlive());
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println("end");
	// // Thread tA = new Thread(new MyFirstThread("A"));
	// // Thread tB = new Thread(new MyFirstThread("B"));
	// // Thread tC = new Thread(new MyFirstThread("C"));
	// // tA.start();
	// // tB.start();
	// // tC.start();
	// }

}
