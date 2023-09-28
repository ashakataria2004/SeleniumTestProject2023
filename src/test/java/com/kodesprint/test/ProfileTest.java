package com.kodesprint.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kodesprint.pages.DashboardPage;
import com.kodesprint.pages.HomePage;
import com.kodesprint.pages.LoginPage;
import com.kodesprint.pages.ProfilePage;

public class ProfileTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(ProfileTest.class);
	SoftAssert sassert = new SoftAssert();

	@Test(groups = { "sanity", "regression" })
	public void profileUpdate() throws Exception {
		logger.info("running - ProfileTest");
		logger.error("Profile error");
		logger.debug("Profile debug error");
		
		HomePage homeObj = new HomePage(driver);
		LoginPage loginObj = new LoginPage(driver);
		ProfilePage profileObj = new ProfilePage(driver);
		DashboardPage dashObj = new DashboardPage(driver);

		homeObj.clickOnAcceptCookieButton();
		homeObj.clickOnLoginLink();

		// this will get you page sosurce of login page
		String pageSource = driver.getPageSource();
		//System.out.println("page source ........" + pageSource);

		loginObj.setUserName("sudheerkumar.gv@gmail.com");
		loginObj.clickOnContinueButton();
		loginObj.setPassword("sudheer@321");
		loginObj.clickOnLoginButton();
		// Validate login successfully
		sassert.assertTrue(dashObj.isProfileIconExist(), "Profile Icon is not displayed");

		dashObj.clickProfile();

		profileObj.setFirstName("angela");
		profileObj.setLastName("angela");
		profileObj.clickSaveProfile();

		// Validate profile saved
		sassert.assertEquals(profileObj.getProfileNotificationMessage(), "Settings saved successfully!",
				"Message is not correct");
		sassert.assertAll();

	}

}
