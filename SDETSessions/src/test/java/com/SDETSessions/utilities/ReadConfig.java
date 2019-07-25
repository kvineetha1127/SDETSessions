package com.SDETSessions.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig()
	{
		File file = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getApplicationURL() {
		String URL=prop.getProperty("baseURL");
		return URL;
	}
	
	public String getUserName()
	{
		String userName=prop.getProperty("username");
		return userName;
	}
	
	public String getPassWord()
	{
		String passWord=prop.getProperty("password");
		return passWord;
	}
	
	public String getChromePath()
	{
		String ChromePath=prop.getProperty("chromePath");
		return ChromePath;
	}
	public String getFirefoxPath()
	{
		String FirefoxPath=prop.getProperty("firefoxPath");
		return FirefoxPath;
	}
}
