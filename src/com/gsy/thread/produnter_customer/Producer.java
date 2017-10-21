package com.gsy.thread.produnter_customer;

public class Producer extends Thread{

	Warehouse warehouse;
	
	
	public Producer(Warehouse obj) {
		this.warehouse = obj;
	}
	
	@Override
	public void run() {
		while (true) {
			warehouse.addProduct();
		}
	}

}
