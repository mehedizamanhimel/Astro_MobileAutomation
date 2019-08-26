package com.todoist.en.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Mobile_LoginScreen {
	
	AndroidDriver driver;
	
	//Constructor
	public Mobile_LoginScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@AndroidFindBy(id="com.todoist:id/email_exists_input")
	public WebElement inputEmail;

	@AndroidFindBy(id="com.todoist:id/btn_continue_with_email")
	public WebElement continueWithEmailButton;
	
	public void provideEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void confirmButtonToContinueWithEmail() {
		continueWithEmailButton.click();
	}
	
}
