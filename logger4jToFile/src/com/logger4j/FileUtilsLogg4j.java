package com.logger4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.logg1.DBUtils;
import com.logg1.DateUtils;

public class FileUtilsLogg4j {

	private static final Log logger = LogFactory.getLog(FileUtilsLogg4j.class);
//	private static final Log logger = LogFactory.getLog("com.logger.FileUtilsCommonLogging");
//	private static final Log logger = LogFactory.getLog(FileUtilsCommonLogging.class.getName());
	
	public void readFile(String fileName){
		if(logger.isDebugEnabled()){
			logger.debug("��ʼ��ȡ�ļ�");
		}
		if(fileName ==null || fileName.trim().equals("")){
			if(logger.isWarnEnabled()){
				logger.warn("�����fileName����Ϊ��");
			}
			return;
		}
		File file= new File(fileName);
		if(!file.exists()){
			if(logger.isInfoEnabled()){
				logger.info("�����fileName����");
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
				logger.error("����FileNotFoundException", e);
			}
		} catch (IOException e) {
			if(logger.isFatalEnabled()){
				logger.fatal("����IOException", e);
			}
		}
	}

	
	public void readFile2(String fileName){
		if(logger.isDebugEnabled()){
			logger.debug("��ʼ��ȡ�ļ�");
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
				logger.error("����FileNotFoundException", e);
			}
		} catch (IOException e) {
			if(logger.isFatalEnabled()){
				logger.fatal("����IOException", e);
			}
		}
	}

	
	public static void main(String[] args) {
		FileUtilsLogg4j fu = new FileUtilsLogg4j();
		fu.readFile("C:\\Users\\Administrator\\Desktop\\a.txt");
		DateUtils du = new DateUtils();
		du.formatDate();
		DBUtils dut = new DBUtils();
		dut.openDataBase();
	}
}
