package com.kodesprint.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello world");

		// open the browser
		System.setProperty("webdriver.chrome.driver", "C:/Users/ashak/Documents/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		// WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// entering the url
		driver.get("https://www.mortgagecalculator.org/");

		// enter values in loan amount - Two fundamental: 1st how to find the element,
		// 2nd-how to perform the action on the found element
		WebElement loanElement = driver.findElement(By.id("loanamt"));
		loanElement.clear();
		loanElement.sendKeys("1000");

		WebElement StartDateElement = driver.findElement(By.name("param[start_month]"));
		Select SelElement = new Select(StartDateElement);
		SelElement.selectByVisibleText("Nov");

		// click on calculate button
		WebElement calElement = driver.findElement(By.name("cal"));
		calElement.click();

	}

}
