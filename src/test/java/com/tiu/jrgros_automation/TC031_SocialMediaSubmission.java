package com.tiu.jrgros_automation;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.ChangePasword;


public class TC031_SocialMediaSubmission extends TestBase {
	
	//WebDriver driver;
	WebDriverWait wait;
	ChangePasword sms;
	
	@BeforeMethod
	public void setup(Method method) throws IOException {
        test = extent.startTest(method.getName());
        test.log(LogStatus.INFO, method.getName() + " test Started");
        init(); // assumes this initializes WebDriver and page objects
        openAppUrl();
        PageFactory.initElements(driver, this);
	  driver = new ChromeDriver(); driver.manage().window().maximize();
	  driver.get("https://www.gladdensociety.org/jrgos-content-application/"); 
	  wait = new WebDriverWait(driver, 10); }
	 

    @Test
    public void testSocialMediaInputFields() throws InterruptedException, AWTException {
    	sms = new ChangePasword(driver);
		// Wait for the link to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='log in']")));

		// Click the link
		loginLink.click();
		// Login details 
		sms.LoginByEmail(); sms.PwdEmail(); sms.SubmitEmail();
		driver.get("https://www.gladdensociety.org/jrgos-content-application/");
		wait_in_seconds(5);
		sms.socialMediaSb();
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
    }	
}