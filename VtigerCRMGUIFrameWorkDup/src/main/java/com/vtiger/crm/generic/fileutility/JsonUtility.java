package com.vtiger.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Exception
	{
		FileReader fr=new FileReader("./ConfigAppData/JCommonData.json");
		JSONParser jsp=new JSONParser();
		Object obj=jsp.parse(fr);
		JSONObject jobj=(JSONObject) obj;
		
		String data = (String) jobj.get(key);
		
		return data;
	}
}
