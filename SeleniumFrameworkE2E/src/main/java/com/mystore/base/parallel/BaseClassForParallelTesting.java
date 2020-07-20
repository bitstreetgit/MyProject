package com.mystore.base.parallel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystore.utility.ExtentManager;

public class BaseClassForParallelTesting {

	public static Properties prop;
	// public static WebDriver driver;

	// 1.Parallel Testing
	// Declare ThreadLocal Driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {

		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\Config.properties");
		prop.load(fis);
	}

	public static WebDriver getDriver() {
		// Get Driver from ThreadLocalMap
		return driver.get();
	}

	// Using testng xml parameterization
	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			// driver = new ChromeDriver();
			// Set Browser to ThreadLocalMap - 1
			driver.set(new ChromeDriver());

		} else if (browserName.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.contains("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			// driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}

		/*
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 * driver.get(prop.getProperty("url"));
		 */

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

	// common methods
	public void waitElement(WebElement e) {
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public static String screenShot(WebDriver driver, String filename) {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
