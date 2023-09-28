
package com.kodesprint.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;

public class SeleniumPracticeTest extends BaseTest {

	@Test
	public void testButton() throws InterruptedException {

		/*
		 * Sometimes while clicking a link, we get the IllegalStateException, to avoid
		 * this exception, the JavaScript executor is used instead of the method click.
		 * click element by using js executor importing the package. creating a
		 * reference calling the method
		 */
		driver.get("https://simplytrainings.blogspot.com/p/selenium-practice-site.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement f = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Prompt Alert']")));
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", f);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("asha");
		Thread.sleep(5000);
		alert.accept();
		Thread.sleep(5000);

	}

}
