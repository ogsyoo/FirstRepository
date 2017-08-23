package com.gsy.templete;

public class Main {
		public static void main(String[] args) {
			TempleteImpl tel = new TempleteImpl();
			tel.test(new Templete() {
				@Override
				public void doSomething(String session) {
					System.out.println(session.toUpperCase());
				}
			});
		}
}
