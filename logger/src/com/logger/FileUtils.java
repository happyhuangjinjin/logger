package com.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {

	public void readFile(String fileName){
		if(fileName ==null || fileName.trim().equals("")){
			System.out.println("传入的fileName不能为空");
			return;
		}
		File file= new File(fileName);
		if(!file.exists()){
			System.out.println("传入的fileName不存");
			return;
		}
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
			byte[] buffed = new byte[1024];
			int len = -1;
			while((len = fs.read(buffed))!=-1){
				System.out.println(new String(buffed, 0, len));
			}
		} catch (FileNotFoundException e) {
			System.out.println("发生FileNotFoundException");
		} catch (IOException e) {
			System.out.println("发生IOException");
		}
	}

	public static void main(String[] args) {
		FileUtils fu = new FileUtils();
		fu.readFile("C:\\Users\\Administrator\\Desktop\\数据库整理.txt");
	}
}
