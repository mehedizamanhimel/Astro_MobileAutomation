package com.todoist.en.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class Mobile_AddProjectPage {
	
	AndroidDriver driver;
	
	//Constructor
	public Mobile_AddProjectPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="com.todoist:id/name")
	WebElement inputProjectName;

	@FindBy(id="com.todoist:id/menu_form_submit")
	WebElement projectNameSubmitButton;
	
	public void provideEmail(String projectName) {
		inputProjectName.sendKeys(projectName);
	}
	
	public void confirmButtonToContinueWithEmail() {
		projectNameSubmitButton.click();
	}
	
/*	public void addProject() {
		(new TouchAction(driver)).press({x: 40, y: 160}).moveTo({x: 93: y: 163}).release().perform();
		  
		(new TouchAction(driver)).tap(776, 765).perform();
		(new TouchAction(driver)).tap(1005, 157).perform();
		(new TouchAction(driver)).tap(259, 149).perform();
	}*/
}
