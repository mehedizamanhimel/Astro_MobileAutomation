package com.todoist.en.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_HomePage {

	AndroidDriver driver;
	
	//Constructor
	public Mobile_HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="")
	WebElement menuButton;
	
	@FindBy(id="")
	WebElement headerContent;
	
	@FindBy(id="")
	WebElement projectList;
	
	@FindBy(id="")
	WebElement addProjectButton;
	
	@FindBy(id="")
	WebElement projectNameField;
	
	@FindBy(id="")
	WebElement createProjectButton;
	
	
	public String getHeaderContent() {
		return headerContent.getText();
	}
	
	public void clickMenuButton() {
		menuButton.click();
	}
	
	public void clickAddProjectButton() {
		addProjectButton.click();
	}
	
	public void inputProjectName(String projectName) {
		projectNameField.sendKeys(projectName);
	}
	
	public void finishCreatingProject() {
		createProjectButton.click();
	}
	
	public String getProjectName() {
		return projectList.getText();
	}
}
