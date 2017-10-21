package com.gsy.thread.produnter_customer;

public class Main {
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		for(int i = 0;i<10;i++) {
			Thread product = new Thread(new Producer(warehouse));
			Thread customer = new Thread(new Customer(warehouse));
			product.start();
			customer.start();
		}
	}
}
