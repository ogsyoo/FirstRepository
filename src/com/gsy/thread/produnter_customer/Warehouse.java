package com.gsy.thread.produnter_customer;

import java.util.ArrayList;
import java.util.List;

public class  Warehouse{
	List<Product> list = new ArrayList<>();
	private final Integer MAX_COUNT = 10;

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public void addProduct() {
		synchronized (list) {
			while (list.size() >= MAX_COUNT) {
				System.out.println("仓库已经满了，请稍后生产!");
				try {
					list.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "正在生产"+"   |  库存："+list.size());
			Product p = new Product();
			list.add(p);
			list.notify();
		}
	}

	public void eatProduct() {
		synchronized (list) {
			while (list.size() == 0) {
				System.out.println("商品卖完了，请等待!");
				try {
					Thread.sleep(1000);
					list.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "正在消费"+"   |  库存："+list.size());
			list.remove(0);
			list.notify();
		}
	}
}
