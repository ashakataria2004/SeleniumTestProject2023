package com.kodesprint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	By btncookie = By.className("a8c-cookie-banner__accept-all-button");
	By lnkLogin = By.partialLinkText("Log");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAcceptCookieButton() throws Exception {
		try {
			Thread.sleep(1000);
			WebElement acceptElement = driver.findElement(btncookie);
			acceptElement.click();
		} catch (Exception e) {

		}
	}

	public void clickOnLoginLink() throws Exception {
		WebElement loginElement = driver.findElement(lnkLogin);
		loginElement.click();
	}

}
