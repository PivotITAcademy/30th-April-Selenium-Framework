package com.naveenautomations.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Utils.ProxyDriver;

public class RegisterAccountPage extends Page {

	public RegisterAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By submitButton = By.cssSelector("input[type=\"submit\"]");
	private By warningMessage = By.cssSelector("#account-register div[class=\"alert alert-danger alert-dismissible\"]");
	List<WebElement> messages;
	String[] texts;

	public void clicksubmitButton() {
		((ProxyDriver) wd).click(submitButton);
		messages = wd.findElements(By.cssSelector("#content div[class=\"text-danger\"]"));
		texts = new String[messages.size()];
	}

	public String textWarningMessage() {
		return ((ProxyDriver) wd).getText(warningMessage);
	}

	public String[] messagesText() {
		int i = 0;
		for (WebElement e : messages) {
			System.out.println(e.getText());
			texts[i] = e.getText();
			i++;
		}
		return texts;
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub
		
	}

}
