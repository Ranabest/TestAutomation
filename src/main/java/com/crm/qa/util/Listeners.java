package com.crm.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public void onFinish(ITestContext arg0) {
		
		
	}

	public void onStart(ITestContext arg0) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		//System.out.println(result.getName());
		//make sure the method is public and static in TestUtil class so that we can use it here.
		//to execute/run ITestListener interface we must use test.xml file to write like <listener/> 
		try {
			TestUtil.getScreenShot(result.getName());
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	public void onTestStart(ITestResult arg0) {
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
	
		
	}

}
