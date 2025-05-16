package com.vtiger.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int count=0;
		int limitCount=4;
		if(count<limitCount) {
			count++;
			return true;
		}
		return false;
	}

}
