package com.kodesprint.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.kodesprint.utils.ReadProperties;

public class BaseTest {

	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	public static ChromeDriver driver;

	ReadProperties prop = new ReadProperties("./src/test/resources/config.properties");

	@BeforeMethod(groups = { "sanity", "regression", "positive" })
	public void initilizeDriver() {
		logger.info("running - beforeMethodAtBase");
	
		
		
		System.out.println("I am before method");

		String driverpath = prop.getPropertyValue("chromedriver_path");
		String baseurl = prop.getPropertyValue("base_url");
		String browser = prop.getPropertyValue("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", driverpath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get(baseurl);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterMethod(groups = { "sanity", "regression", "positive" })
	public void closeDriver() {
		System.out.println("I am after method");
		driver.quit();
	}

	@BeforeClass(groups = { "sanity", "regression", "positive" })
	public void beforeClassMethod() {
		System.out.println("I am before class method");
	}

	@AfterClass(groups = { "sanity", "regression", "positive" })
	public void afterClassMethod() {
		System.out.println("I am after class method");
	}

	@BeforeTest(groups = { "sanity", "regression", "positive" })
	public void beforeTestMethod() {
		System.out.println("I am before test method");
	}

	@AfterTest(groups = { "sanity", "regression", "positive" })
	public void afterTestMethod() {
		System.out.println("I am after test method");
	}

	@BeforeSuite(groups = { "sanity", "regression", "positive" })
	public void beforeSuite() {
		System.out.println("I am before Suite method");
	}

	@AfterSuite(groups = { "sanity", "regression", "positive" })
	public void afterSuite() {
		System.out.println("I am after Suite method");
	}
}
