package Assignments.Astro_MobileAutomation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.todoist.en.api.createProjectAPI;
import com.todoist.en.mobile.Mobile_HomePage;
import com.todoist.en.mobile.Mobile_LoginScreen;
import com.todoist.en.mobile.Mobile_WelComePage;

import io.appium.java_client.android.AndroidDriver;

public class TestMobileApi {
	
	AndroidDriver driver;
	
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
	public void projectCreationByAPI() {
		
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
	
	@AfterTest
	public void afterTest() {
			driver.close();
	}
	
	
}
