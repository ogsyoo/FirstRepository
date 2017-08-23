package com.gsy.io;

import static org.junit.Assert.*;

import java.io.File;

public class Test {

	@org.junit.Test
	public void test() {
		FileCopy file = new FileCopy();
		file.copyFile("D:/1.txt");
	}

}
