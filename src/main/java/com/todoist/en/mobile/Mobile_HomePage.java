package com.todoist.en.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Mobile_HomePage {

	AndroidDriver driver;
	
	//Constructor
	public Mobile_HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy()
	WebElement menuButton;
	
	@FindBy(id="")
	WebElement headerContent;
	
	@FindBy(id="")
	WebElement projectList;
	
	@FindBy(id="")
	WebElement addProjectButton;
	
	@FindBy(id="com.todoist:id/name")
	WebElement projectNameField;
	
	@FindBy(id="com.todoist:id/menu_form_submit")
	WebElement createProjectButton;
	
	
	public String getHeaderContent() {
		return headerContent.getText();
	}
	
	public void clickMenuButton() {
		new TouchAction(driver).longPress(PointOption.point(30, 160))
        .moveTo(PointOption.point(70, 160))
        .release().perform();
	}
	
	public void clickAddProjectButton() {
		new TouchAction(driver).longPress(PointOption.point(755, 771))
        .moveTo(PointOption.point(795, 771))
        .release().perform();
	}
	
	public void inputProjectName(String projectName) {
		projectNameField.sendKeys(projectName);
	}
	
	public void finishCreatingProject() {
		createProjectButton.click();
	}
	
	

	public String VerifyProjectName() {
		return projectList.getText();
	}
}
