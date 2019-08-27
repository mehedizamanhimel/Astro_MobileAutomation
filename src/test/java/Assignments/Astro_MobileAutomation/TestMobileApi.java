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
import com.todoist.en.api.getSingleProject;
import com.todoist.en.mobile.Mobile_HomePage;
import com.todoist.en.mobile.Mobile_LoginScreen;
import com.todoist.en.mobile.Mobile_WelComePage;

import io.appium.java_client.android.AndroidDriver;
import utils.testProperty;

public class TestMobileApi extends AppiumBase {
	
	AndroidDriver driver;
	
	testProperty testData; 
	
	
	public WebDriverWait wait;
	
	public void setUp() throws IOException {
		testData = new testProperty();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("udid", testData.properties.getProperty("device_xiaomi"));
		capabilities.setCapability("deviceName", testData.properties.getProperty("device_xiaomi"));
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
		
		//creating objects for page classes and API classes
		createProjectAPI apiProject = new createProjectAPI();
				
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
		
		//creating objects for page classes and API classes
		createProjectAPI apiProject = new createProjectAPI();
		Mobile_HomePage homePage = new Mobile_HomePage(driver);
		Mobile_LoginScreen loginPage = new Mobile_LoginScreen(driver);
		Mobile_WelComePage welComePage = new Mobile_WelComePage(driver);
		String userEmail = testData.properties.getProperty("email");
		String userPass = testData.properties.getProperty("pass");
		
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
		driver.navigate().back();
		loginPage.providePass(userPass);
		loginPage.confirmButtonToContinueWithEmail();
		
		homePage.getHeaderContent();
		
		Assert.assertEquals(homePage.getHeaderContent(), "Today");
		homePage.clickMenuButton();
		
		homePage.VerifyProjectName();
		
		
	}
	
	@Test(description="Verify that project created in mobile application is verified by API successfully")
	public void projectCreationByMobileVerifiedByAPI() throws IOException, InterruptedException {
		setUp();
		
		
		testData = new testProperty();
		String projectName = RandomStringUtils.randomAlphabetic(9);
		int uuid = RandomUtils.nextInt();
		
		//creating objects for page classes and API classes
		Mobile_HomePage homePage = new Mobile_HomePage(driver);
		Mobile_LoginScreen loginPage = new Mobile_LoginScreen(driver);
		Mobile_WelComePage welComePage = new Mobile_WelComePage(driver);
		getSingleProject getProject = new getSingleProject();
		String userEmail = testData.properties.getProperty("email");
		String userPass = testData.properties.getProperty("pass");
		
		welComePage.selectEmail();
		welComePage.cancel();
		
		//Login with current email
		loginPage.provideEmail(userEmail);
		loginPage.confirmButtonToContinueWithEmail();
		loginPage.providePass(userPass);
		loginPage.loginWithEmail();
		
		//Going to homePage, verify the header is the same name, creating a project
		homePage.getHeaderContent();
		Assert.assertEquals(homePage.getHeaderContent(), "TodoIst");
		homePage.clickMenuButton();
		homePage.clickAddProjectButton();
		homePage.inputProjectName(projectName);
		homePage.finishCreatingProject();
		getProject.getProjectName();
		
		//Verifying the created project in API via comparing the project name
		Assert.assertEquals(getProject.getProjectName(), projectName);
						
	}
	
}
