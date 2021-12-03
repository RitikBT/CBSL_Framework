package org.cbsl.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private FileInputStream fileInput;
	private Properties prop;
	private String fileName="src/test/resources/config.properties";
	
	public void propertiesFile() {
		
		File file = new File(fileName);
		  
		 fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String keyName) {
		if(fileInput==null) {
			propertiesFile();
		}
	 	String a= prop.getProperty(keyName);
			return a;
	}
	
	

}
