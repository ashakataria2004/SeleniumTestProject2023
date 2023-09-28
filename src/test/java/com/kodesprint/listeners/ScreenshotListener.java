package com.kodesprint.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.kodesprint.test.BaseTest;

public class ScreenshotListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		File srcFile = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./screenshots/"+result.getName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
