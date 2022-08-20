package com.naveenautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver webDriver;
	public Properties prop;

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

		webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("base_url"));
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);
	}

	public void quitBrowser() {
		webDriver.quit();
	}
}
