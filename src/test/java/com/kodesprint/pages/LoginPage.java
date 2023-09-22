package com.kodesprint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	By txtEmailId = By.id("usernameOrEmail");
	By labelPasswordErrorMessage = By.xpath("//div[@class='form-input-validation is-error']/span");
	By btnContinue = By.xpath("//button[contains(text(),'Continue')]");
	By txtPassword = By.id("password");
	By btnLoginIn = By.xpath("//button[contains(text(),'Log In')]");

	public void setUserName(String userName) {
		WebElement emailElement = driver.findElement(txtEmailId);
		emailElement.clear();
		emailElement.sendKeys(userName);
	}
	public void clickOnContinueButton() throws Exception {
		WebElement continueElement = driver.findElement(btnContinue);
		continueElement.click();
	}
	public void setPassword(String password) {
		WebElement pwdElement = driver.findElement(txtPassword);
		pwdElement.clear();
		pwdElement.sendKeys(password);
	}
	public String getErrorMessage() {
		WebElement invalidPwdMessageElement = driver.findElement(labelPasswordErrorMessage);
		return invalidPwdMessageElement.getText();
	}
	public void clickOnLoginButton() throws Exception {
		WebElement LoginElement = driver.findElement(btnLoginIn);
		LoginElement.click();
	}

}
