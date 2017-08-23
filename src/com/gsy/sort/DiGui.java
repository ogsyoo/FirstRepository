package com.gsy.sort;

import java.io.File;

public class DiGui {
	public static void main(String[] args) {
		//		System.out.println(diGui(5));
		file("D:/论文",0);
	}

	public static int diGui(int i){
		if(i==1)
			return 1;
		return i*diGui(i-1);
	}

	//递归展示树形列表
	public static void file(String path,int level){
		File file  = new File(path);
		StringBuilder tab = new StringBuilder();
		if(level==0){
			System.out.println(file.getName());
			tab.append("    ");
		}
		for(int j = 0;j<level;j++){
			tab.append("\t");
		}
		tab.append("|-");
		if(file.exists()){
			File[] files = file.listFiles();
			for(int i = 0;i<files.length;i++){
				System.out.println(tab+files[i].getName());
				if(files[i].isDirectory()){
					file(files[i].getAbsolutePath(),level+1);
				}
			}
		}else{
			System.out.println("目标文件不存在！");
		}
	}
}

