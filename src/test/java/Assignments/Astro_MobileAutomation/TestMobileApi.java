package Assignments.Astro_MobileAutomation;

import java.io.IOException;

import org.apache.commons.lang3.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.todoist.en.api.createProjectAPI;
import com.todoist.en.mobile.Mobile_HomePage;
import com.todoist.en.mobile.Mobile_LoginScreen;
import com.todoist.en.mobile.Mobile_WelComePage;

import io.appium.java_client.android.AndroidDriver;
import utils.testProperty;

public class TestMobileApi {
	
	AndroidDriver driver;
	
	testProperty testData; 
	
	public TestMobileApi() {
		
	}
	
	createProjectAPI apiProject = new createProjectAPI();
	Mobile_HomePage homePage = new Mobile_HomePage(driver);
	Mobile_LoginScreen loginPage = new Mobile_LoginScreen(driver);
	Mobile_WelComePage welComePage = new Mobile_WelComePage(driver);
	
	
	@BeforeTest
	public void beforeTest() {
		
	}
	
	@Test
	public void projectCreationByAPI() throws IOException {
		testData = new testProperty();
		String projectName = RandomStringUtils.randomAlphabetic(9);
		int uuid = RandomUtils.nextInt();
		
		apiProject.createProject(testData.properties.getProperty("Authorization"), uuid, projectName);
		System.out.println("The Project Name given is :"+projectName);
		System.out.println("The uuid given is :"+uuid);
		
		System.out.println("The Project Name created is :"+apiProject.getProjectName());
		System.out.println("The uuid created is :"+apiProject.getID());
		//System.out.println("The response code is :"+apiProject.getResponseCode());
		Assert.assertEquals(apiProject.getProjectName(), projectName);
	}
	
	@Test
	public void verifyProjectinMobile() {
		
	}
	
	@Test
	public void projectCreationByMobile() {
		
	}
	
	@Test
	public void verifyProjectinAPI() {
		
	}

	
	
}
