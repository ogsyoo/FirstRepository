package com.gsy.alwaysTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Test {
	public static void main(String argv[]) {
		
		
		
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        for (int i = 0; i < 10000; i++) {
		            new Thread(new Runnable() {
		                @Override
		                public void run() {
		                    map.put(UUID.randomUUID().toString(), "");
		                }
		            }, "ftf" + i).start();
		            System.out.println("插入map:  "+i);
		        }
		    }
		}, "ftf");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
//		Set<String> set = new HashSet<>();
//		List<Object> list = new LinkedList<>();
//		list.add("A");
//		list.add(1,"B");
////		String s = (String) list.get(1);
//		System.out.println(list.get(0));
	}
}
