package com.todoist.en.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_LoginScreen {
	
	AndroidDriver driver;
	
	//Constructor
	public Mobile_LoginScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="")
	WebElement inputEmail;

	@FindBy(id="")
	WebElement continueWithEmailButton;
	
	public void provideEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void confirmButtonToContinueWithEmail() {
		continueWithEmailButton.click();
	}
	
}
