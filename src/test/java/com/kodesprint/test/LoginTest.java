package com.kodesprint.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kodesprint.pages.DashboardPage;
import com.kodesprint.pages.HomePage;
import com.kodesprint.pages.LoginPage;

public class LoginTest extends BaseTest {
		
	@DataProvider(name = "valid_login_data")
	public Object[][] validLoginData() {
	 return new Object[][] {
	   { "sudheerkumar.gv@gmail.com", "sudheer@321"}
	    };
	}
		@DataProvider(name = "invalid_login_data")
	public Object[][] invalidLoginData() {
	 return new Object[][] {
	   { "sudheerkumar.gv@gmail.com", "","Don't forget to enter your password." },
	   { "sudheerkumar.gv@gmail.com", "aaa","Oops, that's not the right password. Please try again!" },
	   };
	}
	
	
	
	@Test(dataProvider = "valid_login_data", priority=1, groups = {"sanity","regression","positive" })
	public void validLogin(String username, String password) throws Exception {
		System.out.println("I am validLoginc");
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

	
	
	 
	@Test(dataProvider = "invalid_login_data",priority=1,groups = {"regression","negative"})
	public void testInValidLoginByEmptyPassword(String username, String password,String expectedErrorMsg) throws Exception {
		LoginPage loginObj = new LoginPage(driver);
		HomePage homeObj = new HomePage(driver);

		homeObj.clickOnAcceptCookieButton();
		homeObj.clickOnLoginLink();

		loginObj.setUserName(username);
		loginObj.clickOnContinueButton();
		loginObj.setPassword(password);
		loginObj.clickOnLoginButton();
		String actualErrorMessage = loginObj.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMsg);
		
	}

	
}