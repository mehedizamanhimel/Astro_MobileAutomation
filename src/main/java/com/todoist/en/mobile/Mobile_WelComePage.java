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
	
	@FindBy(id="com.todoist:id/btn_google")
	WebElement continueWithFaceBook;
	
	@FindBy(id="com.todoist:id/btn_facebook")
	WebElement continueWithGoogle;
	
	@FindBy(id="com.todoist:id/btn_welcome_continue_with_email")
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
