package com.tiu.jrgros_automation;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TC03_LoginInvalidTest extends TestBase{
	public static final Logger log = Logger.getLogger(TC03_LoginInvalidTest.class.getName());

	/*
	 * @BeforeClass public static void startTest() { test =
	 * extent.startTest("TC03_LoginInvalidTest"); }
	 */
    @FindBy(id = "user-4dd5c2d")
    public static WebElement loginField;

    @FindBy(id = "password-4dd5c2d")
    public static WebElement passwordField;

   // @FindBy(xpath = "//button[@name='wp-submit']")
    @FindBy(name = "wp-submit")
   public static WebElement signInButton;

    //Not useful in this code
   // @FindBy(name = "accept") // changed from wp-submit for acceptButton to avoid duplicate @FindBy
   // public static WebElement acceptButton;

    

    @BeforeMethod
    public void setup(Method method) throws IOException {
        test = extent.startTest(method.getName());
        test.log(LogStatus.INFO, method.getName() + " test Started");
        init(); // assumes this initializes WebDriver and page objects
        openAppUrl();
        PageFactory.initElements(driver, this);
    }

    @Test
	public void Signin() throws IOException, InterruptedException, AWTException {
        waitInSeconds(15);

        try {
            if (loginField.isDisplayed()) {
                loginField.click();
            }
        } catch (NoSuchElementException e) {
            log.warn("Login field not found: " + e.getMessage());
        }

    
       // waitInSeconds(3);

        // ✅ Provide incorrect input values for login
        loginField.sendKeys("Test@tiuconsulting.com"); // replace with actual test user email
       passwordField.sendKeys("Tiu@glad1");   // replace with actual password
       	waitInSeconds(5);
        //scrollDownToElement(signInButton);
       	// waitInSeconds(5);
        signInButton.click();
        //waitInSeconds(5);
		
		
      //  driver.quit();
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
    }


}
