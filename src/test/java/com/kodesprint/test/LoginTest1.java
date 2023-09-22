package com.kodesprint.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kodesprint.pages.DashboardPage;
import com.kodesprint.pages.HomePage;
import com.kodesprint.pages.LoginPage;

public class LoginTest1 extends BaseTest {
		
	@DataProvider(name = "valid_login_data")
	public Object[][] validLoginData() {
	 return new Object[][] {
	   { "sudheerkumar.gv@gmail.com", "sudheer@321"}
	    };
	}
		
	
	
	
	@Test(dataProvider = "valid_login_data",groups = {"regression", "sanity"})
	public void validLogin(String username, String password) throws Exception {
		LoginPage loginObj = new LoginPage(driver);
		HomePage homeObj = new HomePage(driver);
		DashboardPage dashObj = new DashboardPage(driver);

		homeObj.clickOnAcceptCookieButton();
		homeObj.clickOnLoginLink();

		loginObj.setUserName(username);
		loginObj.clickOnContinueButton();
		loginObj.setPassword(password);
		loginObj.clickOnLoginButton();

		Assert.assertTrue(dashObj.isProfileIconExist());
	}

	
	
	
	
}