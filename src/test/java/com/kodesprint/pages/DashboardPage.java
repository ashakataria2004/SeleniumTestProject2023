package com.kodesprint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DashboardPage {
	
	private WebDriver driver;
	By imgProfile = By.xpath("//a[@title='Update your profile, personal settings, and more']");

	public DashboardPage(WebDriver driver) {
	this.driver = driver;
	    }
	public boolean isProfileIconExist() {
		WebElement updateprofileElement = driver.findElement(imgProfile);
		return updateprofileElement.isDisplayed();
		}
	public void clickProfile() throws Exception {
		Thread.sleep(3000);
		WebElement updateprofileElement = driver.findElement(imgProfile);
		updateprofileElement.click();
		}
}
