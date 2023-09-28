package com.kodesprint.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import org.apache.logging.log4j.LogManager;

//import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kodesprint.pages.DashboardPage;
import com.kodesprint.pages.HomePage;
import com.kodesprint.pages.LoginPage;

public class LoginTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(LoginTest.class);

	// Logger log = Logger.get

	@DataProvider(name = "valid_login_data")
	public Object[][] validLoginData() {
		return new Object[][] { { "sudheerkumar.gv@gmail.com", "sudheer@321" } };
	}

	@DataProvider(name = "invalid_login_data")
	public Object[][] invalidLoginData() {
		return new Object[][] { { "sudheerkumar.gv@gmail.com", "", "Don't forget to enter your password." },
				{ "sudheerkumar.gv@gmail.com", "aaa", "Oops, that's not the right password. Please try again!" }, };
	}

	/*@DataProvider(name = "skip_parameter")
	public Object[][] skipparameter()  {
		return new Object[][] { { "parameter1", "parameter2","parameter3" } };
	}

	@Test(dataProvider = "skip_parameter",groups = { "sanity", "regression",  })
	public void t(String parameter) {
		System.out.println("test method to be called with the following parameter is " + parameter);
	}
*/
	@Test(dataProvider = "valid_login_data", priority = 1, groups = { "sanity", "regression", "positive" })
	public void validLogin(String username, String password) throws Exception {

		logger.info("running - ValidLogin");
		logger.error("login error");
		logger.debug("login debug error");

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

	@Test(dataProvider = "invalid_login_data", priority = 1, groups = { "regression", "negative" })
	public void testInValidLoginByEmptyPassword(String username, String password, String expectedErrorMsg)
			throws Exception {
		logger.info("running - InvalidLogin");
		logger.error("invalid login error");
		logger.debug("invalid login debug error");
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