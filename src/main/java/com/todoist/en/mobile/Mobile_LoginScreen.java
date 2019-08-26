package com.todoist.en.mobile;

import java.text.MessageFormat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Mobile_LoginScreen {
	
	AndroidDriver driver;
	
	//Constructor
	public Mobile_LoginScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="com.todoist:id/email_exists_input")
	//@FindBy(className="android.widget.EditText")
	//@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	public WebElement inputEmail;
	
	@FindBy(id="com.todoist:id/log_in_password")
	//@FindBy(className="android.widget.EditText")
	public WebElement inputPass;

	@FindBy(id="com.todoist:id/btn_log_in")
	public WebElement loginButton;
	
	@FindBy(id="com.todoist:id/btn_continue_with_email")
	public WebElement continueWithEmailButton;
	
	public void provideEmail(String email) {
		//inputEmail.click();
		//driver.executeScript("mobile: shell", ImmutableMap.of("command", MessageFormat.format("input text {0}", email)));
		inputEmail.sendKeys(email);
		//inputEmail.submit();
	}
	
	public void providePass(String pass) {
		//inputPass.click();
		inputPass.sendKeys(pass);
		//driver.executeScript("mobile: shell", ImmutableMap.of("command", MessageFormat.format("input text {0}", pass)));
	}
	
	public void confirmButtonToContinueWithEmail() {
		continueWithEmailButton.click();
	}
	
	public void loginWithEmail() {
		loginButton.click();
	}
	
}
