package com.tiu.jrgros_automation;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
public class TC01_LoginVerify extends TestBase {

	//public static final Logger log = Logger.getLogger(TC01_LoginVerify.class.getName());

	/*
	 * @BeforeClass public static void startTest() { test =
	 * extent.startTest("TC01_LoginVerify"); }
	 */

	@BeforeMethod
	public void setup(Method result) throws IOException {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init(); // assumes this initializes WebDriver and page objects
		openAppUrl();
		PageFactory.initElements(driver, this);

		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init();
	}
	

	
	@FindBy(id = "user-4dd5c2d")
	public static WebElement loginField;

	@FindBy(id = "password-4dd5c2d")
	public static WebElement passwordField;

	// @FindBy(xpath = "//button[@name='wp-submit']")
	@FindBy(name = "wp-submit")
	public static WebElement signInButton;
	

	@Test
	public void Signin() throws IOException, InterruptedException, AWTException {
		waitInSeconds(15);

		try {
			if (loginField.isDisplayed()) {
				loginField.click();
			}
		} catch (NoSuchElementException e) {
			// log.warn("Login field not found: " + e.getMessage());
		}

		// Not useful in this code
		/*
		 * log.info("Clicking on signIn button");
		 * 
		 * try { if (signInButton.isDisplayed()) { waitInSeconds(10);
		 * signInButton.click(); waitInSeconds(3); } } catch (NoSuchElementException e)
		 * { log.warn("Accept button not found: " + e.getMessage()); }
		 * 
		 */
		// waitInSeconds(3);

		// ✅ Provide correct input values for login
		loginField.sendKeys("vvaidya@tiuconsulting.com"); // replace with actual test user email
		passwordField.sendKeys("Tiu@gladden1"); // replace with actual password
		waitInSeconds(5);
		// scrollDownToElement(signInButton);
		// waitInSeconds(5);
		signInButton.click();
		waitInSeconds(5);

		/*
		 * TC02_ChangePwd tcp = new TC02_ChangePwd(); tcp.testChangePassword();
		 * wait_for_page_load(5); waitInSeconds(10); tcp.testChangePassword();
		 */

		//driver.quit();
	}

	@AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
    }

}