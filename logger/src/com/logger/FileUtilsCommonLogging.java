package com.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtilsCommonLogging {

	private static final Log logger = LogFactory.getLog(FileUtilsCommonLogging.class);
//	private static final Log logger = LogFactory.getLog("com.logger.FileUtilsCommonLogging");
//	private static final Log logger = LogFactory.getLog(FileUtilsCommonLogging.class.getName());
	
	public void readFile(String fileName){
		if(logger.isDebugEnabled()){
			logger.debug("开始读取文件");
		}
		if(fileName ==null || fileName.trim().equals("")){
			if(logger.isWarnEnabled()){
				logger.warn("传入的fileName不能为空");
			}
			return;
		}
		File file= new File(fileName);
		if(!file.exists()){
			if(logger.isInfoEnabled()){
				logger.info("传入的fileName不存");
			}
			return;
		}
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
			byte[] buffed = new byte[1024];
			int len = -1;
			while((len = fs.read(buffed))!=-1){
				if(logger.isDebugEnabled()){
					logger.debug(new String(buffed, 0, len));
				}
			}
		} catch (FileNotFoundException e) {
			if(logger.isErrorEnabled()){
				logger.error("发生FileNotFoundException", e);
			}
		} catch (IOException e) {
			if(logger.isFatalEnabled()){
				logger.fatal("发生IOException", e);
			}
		}
	}

	
	public void readFile2(String fileName){
		if(logger.isDebugEnabled()){
			logger.debug("开始读取文件");
		}
		File file= new File(fileName);
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
			byte[] buffed = new byte[1024];
			int len = -1;
			while((len = fs.read(buffed))!=-1){
				if(logger.isDebugEnabled()){
					logger.debug(new String(buffed, 0, len));
				}
			}
		} catch (FileNotFoundException e) {
			if(logger.isErrorEnabled()){
				logger.error("发生FileNotFoundException", e);
			}
		} catch (IOException e) {
			if(logger.isFatalEnabled()){
				logger.fatal("发生IOException", e);
			}
		}
	}

	
	public static void main(String[] args) {
		FileUtilsCommonLogging fu = new FileUtilsCommonLogging();
//		fu.readFile("C:\\Users\\Administrator\\Desktop\\数据库整理1.txt");
//		fu.readFile("");
		fu.readFile2("");
	}
}
