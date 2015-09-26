package com.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {

	public void readFile(String fileName){
		if(fileName ==null || fileName.trim().equals("")){
			System.out.println("�����fileName����Ϊ��");
			return;
		}
		File file= new File(fileName);
		if(!file.exists()){
			System.out.println("�����fileName����");
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
			System.out.println("����FileNotFoundException");
		} catch (IOException e) {
			System.out.println("����IOException");
		}
	}

	public static void main(String[] args) {
		FileUtils fu = new FileUtils();
		fu.readFile("C:\\Users\\Administrator\\Desktop\\���ݿ�����.txt");
	}
}
