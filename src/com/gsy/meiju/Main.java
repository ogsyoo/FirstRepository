package com.gsy.meiju;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
		// EnumTest[] values = EnumTest.values();
		// for (EnumTest s : values) {
		// System.out.println(s);
		// }
		Enum_001 e = Enum_001.getE(2);
		System.out.println(e.getText());
		//EnumMap的使用
        EnumMap<Enum_001, String> weekMap = new EnumMap(Enum_001.class);
        weekMap.put(Enum_001.city, "城市");
        for (Iterator<Entry<Enum_001, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Entry<Enum_001, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
		System.out.println(EnumTest.red.compareTo(EnumTest.blue));
		System.out.println(EnumTest.red.color());
	}
}
