package Generic_Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertyFiles implements ApplicationConstants
{
	FileInputStream fis;
	Properties p;
    public ReadPropertyFiles() throws Exception
    {
	 fis=new FileInputStream(PropertyPath);
	p= new Properties();
	p.load(fis);
    }
    public String EntertestUrl()
    {
    	String testUrl = p.getProperty("testUrl");
    	return testUrl;
    }
    public String EntertestUsn()
    {
    	String testUsn = p.getProperty("testUsn");
    	return testUsn;
    }
    public String EntertestPwd()
    {
    	String testPwd = p.getProperty("testUsn");
    	return testPwd;
    }
	
	
	
	
	
}
