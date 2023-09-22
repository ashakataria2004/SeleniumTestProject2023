package com.kodesprint.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Locators {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/ashak/Documents/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver  driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		
		driver.get("https://simplytrainings.blogspot.com/p/selenium-practice-site.html");
		
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("anegla");
		
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("password")).sendKeys("anegla");
	    driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	     
	     driver.findElement(By.xpath("//Input[@value='Female']")).click();
		
	    WebElement selectCars= driver.findElement(By.xpath("//Select[@name='cars']"));
	    Select car = new Select(selectCars);
	    car.selectByVisibleText("Opel");
	    
	    WebElement selectStates = driver.findElement(By.xpath("//select[@name='States']")); 
	    
	    Select selectState = new Select(selectStates);
	    selectState.selectByVisibleText("New Jersey");
	    
	    
	    //driver.findElement(By.xpath("//button[@fdprocessedid='zjqeqn']")).click();
	    driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();
	    
	 // Wait for the alert to be displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	           wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Click on the alert
        alert.sendKeys("this is accept alert");
        
        Thread.sleep(1000);
        
        //alert.accept();
        
        

	    
	    
	}

}
