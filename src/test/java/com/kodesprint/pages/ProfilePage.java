package com.kodesprint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

	private WebDriver driver;
	By txtFirstname = By.id("first_name");
	By txtLastname = By.id("last_name");
	By btnSaveprofile = By.xpath("//button[contains(text(),'Save profile details')]");
    By saveprofilenotification= By.xpath("//span[@class='notice__text']");
    
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	public void setFirstName(String firstname) throws Exception {
		WebElement firstnameElement = driver.findElement(txtFirstname);
		firstnameElement.clear();
		firstnameElement.sendKeys(firstname);
	}
	public void setLastName(String lastname) throws Exception {
		WebElement lastnameElement = driver.findElement(txtLastname);
		lastnameElement.clear();
		lastnameElement.sendKeys(lastname);
	}
	public void clickSaveProfile() throws Exception {
		WebElement saveProfileElement = driver.findElement(btnSaveprofile);
		saveProfileElement.click();
	
	}
	
	
	public String getProfileNotificationMessage() throws Exception {
		WebElement getProfileNotificationMessageElement = driver.findElement(saveprofilenotification);
		return getProfileNotificationMessageElement.getText();
	
	}

}
