package Assignments.Astro_MobileAutomation;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.todoist.en.api.createProjectAPI;
import com.todoist.en.mobile.Mobile_HomePage;
import com.todoist.en.mobile.Mobile_LoginScreen;
import com.todoist.en.mobile.Mobile_WelComePage;

import io.appium.java_client.android.AndroidDriver;
import utils.testProperty;

public class TestMobileApi extends AppiumBase {
	
	AndroidDriver driver;
	
	testProperty testData; 
	
	public TestMobileApi() {
		
	}
	
	createProjectAPI apiProject = new createProjectAPI();
	public String projectName = RandomStringUtils.randomAlphabetic(9);
	public WebDriverWait wait;
	
	public void setUp() throws IOException {
		testData = new testProperty();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("udid", testData.properties.getProperty("device_op6"));
		capabilities.setCapability("deviceName", testData.properties.getProperty("device_op6"));
		capabilities.setCapability("newCommandTimeout", 2400);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("autoGrantPermissions ", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("appPackage", testData.properties.getProperty("appPackage"));
		capabilities.setCapability("appActivity", testData.properties.getProperty("appActivity"));
		capabilities.setCapability("skipUnlock", true);
		capabilities.setCapability("skipDeviceInitialization", true);
		capabilities.setCapability("ignoreUnimportantViews", true);
		capabilities.setCapability("disableAndroidWatchers", true);
		capabilities.setCapability("systemPort", 8202);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}
	
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
	
	@Test(description="Verify that project created by API is verified in mobile application successfully")
	public void projectCreationAndVerifyProjectinMobile() throws IOException {
		setUp();
		testData = new testProperty();
		String projectName = RandomStringUtils.randomAlphabetic(9);
		int uuid = RandomUtils.nextInt();
		
		Mobile_HomePage homePage = new Mobile_HomePage(driver);
		Mobile_LoginScreen loginPage = new Mobile_LoginScreen(driver);
		Mobile_WelComePage welComePage = new Mobile_WelComePage(driver);
		String userEmail = testData.properties.getProperty("email");
		
		apiProject.createProject(testData.properties.getProperty("Authorization"), uuid, projectName);
		System.out.println("The Project Name given is :"+projectName);
		System.out.println("The uuid given is :"+uuid);
		
		System.out.println("The Project Name created is :"+apiProject.getProjectName());
		System.out.println("The uuid created is :"+apiProject.getID());
		//System.out.println("The response code is :"+apiProject.getResponseCode());
		Assert.assertEquals(apiProject.getProjectName(), projectName);
		
		
		welComePage.selectEmail();
		driver.navigate().back();
		loginPage.provideEmail(userEmail);
		loginPage.confirmButtonToContinueWithEmail();
		
		homePage.getHeaderContent();
		
		Assert.assertEquals(homePage.getHeaderContent(), "Today");
		homePage.clickMenuButton();
		
		homePage.getProjectName();
		
		
	}
	
	@Test(description="Verify that project created in mobile application is verified by API successfully")
	public void projectCreationByMobileVerifiedByAPI() throws IOException {
		setUp();
		
		testData = new testProperty();
		String projectName = RandomStringUtils.randomAlphabetic(9);
		int uuid = RandomUtils.nextInt();
		
		Mobile_HomePage homePage = new Mobile_HomePage(driver);
		Mobile_LoginScreen loginPage = new Mobile_LoginScreen(driver);
		Mobile_WelComePage welComePage = new Mobile_WelComePage(driver);
		String userEmail = testData.properties.getProperty("email");
		
		
		welComePage.selectEmail();
		driver.navigate().back();
		loginPage.provideEmail(userEmail);
		loginPage.confirmButtonToContinueWithEmail();
		
		homePage.clickMenuButton();
		homePage.clickAddProjectButton();
		
		
	}

	
	
}
