package com.gsy.thread;

public class DeadLock implements Runnable{
		public int flag = 1;  
		//静态对象是类的所有对象共享的  
	    private static Object o1 = new Object(), o2 = new Object();  
	    @Override 
	    public void run() {  
			if (flag == 1) {  
	            synchronized (o1) {  
	                try {  
	                    Thread.sleep(500);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	                synchronized (o2) {  
	                    System.out.println("1");  
	                }  
	            }  
	        }  
	        if (flag == 0) {  
	            synchronized (o2) {  
	                try {  
	                    Thread.sleep(500);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	                synchronized (o1) {  
	                    System.out.println("0");  
	                }  
	            }  
	        }  
	    }
	    
	    public static void main(String[] args) {
	    	DeadLock dl1 = new DeadLock();
	    	DeadLock dl2 = new DeadLock();
	    	dl1.flag = 1;
	    	dl2.flag = 0;
	    	new Thread(dl1).start();
	    	new Thread(dl2).start();
	    		
	    	
		}
}

