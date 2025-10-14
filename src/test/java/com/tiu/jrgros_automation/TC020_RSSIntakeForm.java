package com.tiu.jrgros_automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.ChangePasword;
import com.tiu.test_base.TestBase;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class TC020_RSSIntakeForm extends TestBase{

	WebDriver driver;
	WebDriverWait wait;
	ChangePasword rss;

	@BeforeMethod
	
	  public void setup(Method result) throws IOException { 
		 test = extent.startTest(result.getName());
	        test.log(LogStatus.INFO, result.getName() + " test Started");
	        init(); // assumes this initializes WebDriver and page objects
	        openAppUrl();
	        PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe"); 
	  driver = new ChromeDriver(); 
	  driver.manage().window().maximize();
	  driver.get("https://www.gladdensociety.org/rss-intake-application/"); 
	  wait = new WebDriverWait(driver, 10); }
	 

	@Test
	public void fillRSSIntakeForm() throws InterruptedException, AWTException {

		rss = new ChangePasword(driver);
		// Wait for the link to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement loginLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='log in']")));

		// Click the link
		loginLink.click();

		// Login details
		rss.LoginByEmail();
		rss.PwdEmail();
		rss.SubmitEmail();

		Thread.sleep(5000);
		driver.get("https://www.gladdensociety.org/rss-intake-application/");

		rss.RSSFName();
		rss.RSSLName();
		rss.RSSEmail();
		rss.RSSProgramName();
		rss.RSSBrief();
		rss.RSSConcerns();
		rss.rssPGYDropdown();
		rss.rssRadioBtn();
		rss.rssVideoUpload();
		//rss.rssVideoFiles("//div[@class='dz-message']");
		
		 Thread.sleep(10);
		
			/*
			 * // Optional: Wait for confirmation
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//div[@class='dz-message']")));
			 */
		//rss.RSSSubmit();

	}

	
	 @AfterMethod
	    public void afterMethod(ITestResult result) {
	        get_result(result);
	    }}
