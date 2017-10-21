package com.gsy.thread.produnter_customer;

public class Customer extends Thread {

	 Warehouse warehouse;
	 
	 public Customer(Warehouse obj ) {
		this.warehouse = obj;
	}
	
	
	@Override
	public void run() {
		while (true) {
			warehouse.eatProduct();
		}
	}
}
