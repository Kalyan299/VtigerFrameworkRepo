package com.vtiger.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

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

	@Test
	public void onTest() {
		System.out.println("execute");
	}
}
