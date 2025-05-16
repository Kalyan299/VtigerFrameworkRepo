package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{

	public String getDatafromPropertiesFile(String key) throws Exception 
	{
		FileInputStream fis=new FileInputStream("./ConfigAppData/data.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String data=pro.getProperty(key);
		
		return data;
		
	}
}
