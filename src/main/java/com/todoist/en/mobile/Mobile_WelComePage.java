package com.todoist.en.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_WelComePage {
	
	AndroidDriver driver;
	
	//Constructor
	public Mobile_WelComePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="")
	WebElement continueWithFaceBook;
	
	@FindBy(id="")
	WebElement continueWithGoogle;
	
	@FindBy(id="")
	WebElement continueWithEmail;
	
	public void selectFacebook() {
		continueWithFaceBook.click();
	}
	
	public void selectGoogle() {
		continueWithGoogle.click();
	}
	
	public void selectEmail() {
		continueWithEmail.click();
	}
	
}
