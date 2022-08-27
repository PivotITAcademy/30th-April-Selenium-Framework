package com.naveenautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Utils.ProxyDriver;
import com.naveenautomation.Utils.Utils;
import com.naveenautomation.Utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver webDriver;
	public Properties prop;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEvents events;
	public static JavascriptExecutor jse;

	public TestBase() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"F:\\Carbonite\\testingframework\\src\\main\\java\\com\\naveenautomation\\Config\\config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void loggerSetUp() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);
	}

	public void intialization() {
		// Manages the driver for the browser on which testing is performed
		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			webDriver = WebDriverManager.chromedriver().create();
			// webDriver=new ChromeDriver();
			break;
		case "firefox":
			webDriver = WebDriverManager.firefoxdriver().create();
			break;
		case "edge":
			webDriver = WebDriverManager.edgedriver().create();
			break;

		default:
			System.out.println(("Verify you have passed the correct browser name"));
			break;
		}

		jse=(JavascriptExecutor) webDriver;
		
		e_driver = new EventFiringWebDriver(webDriver);
		events = new WebDriverEvents();
		e_driver.register(events);

		webDriver = e_driver;

		webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("base_url"));
		webDriver.manage().deleteAllCookies();
	}

	public void quitBrowser() {
		webDriver.quit();
	}
	
	public void waitForDocumentCompleteState(int timeOutInSeconds) {
		new WebDriverWait(webDriver, timeOutInSeconds).until((ExpectedCondition<Boolean>) v -> {
			logger.info("Verifying page has loaded......");
			jse = (JavascriptExecutor) webDriver;
			String documentIsReady = jse.executeScript("return document.readyState").toString();
			while (true) {
				if (documentIsReady.equalsIgnoreCase("complete")) {
					logger.info("Page has loaded completely......");
					return true;
				} else {
					return false;
				}
			}
		});
	}
}
