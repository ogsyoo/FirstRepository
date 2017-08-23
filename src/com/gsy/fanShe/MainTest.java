package com.gsy.fanShe;

import java.lang.reflect.Method;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		try {
			//第一种
			Class clazz1 = Class.forName("com.gsy.fanShe.FanShe");
			//第二种
			Class clazz2 = FanShe.class;
			//第三种
			FanShe fanshe = new FanShe();
			Class clazz3 = fanshe.getClass();
			Method[] declaredMethods = clazz3.getDeclaredMethods();
			for(Method dec :declaredMethods){
				System.out.println(dec.getName());
			}
			FanShe newInstance = (FanShe) clazz3.newInstance();
			Method method = clazz3.getMethod("setId", String.class);
			method.invoke(newInstance, "123");
			
//			Object object = clazz.newInstance();
//			object.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
