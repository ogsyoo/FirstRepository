package com.gsy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public void copyFile(String path) {
		File file = new File(path);
		File file1 = new File("D:/2.txt");
		try {
			InputStream inputStream = new FileInputStream(file);
			OutputStream outputStream = new FileOutputStream(file1);
			byte[] b = new byte[1024];
			int len;
			while ((len = inputStream.read(b))!=-1) {
				outputStream.write(b, 0, len);
			}
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
