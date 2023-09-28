package com.kodesprint.test;

import org.testng.annotations.Test;

import com.kodesprint.pages.HomePage;

public class WordPressNavigationTest extends BaseTest {

	@Test
	public void testNavigation() throws Exception {

		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnAcceptCookieButton();
		homeObj.clickOnLoginLink();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

}
