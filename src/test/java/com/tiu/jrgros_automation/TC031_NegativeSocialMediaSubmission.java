package com.tiu.jrgros_automation;

import static org.testng.AssertJUnit.assertTrue;
import java.awt.AWTException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import com.tiu.page_object.ChangePasword;

public class TC031_NegativeSocialMediaSubmission extends TestBase {
		ChangePasword nsm;
	
		@BeforeMethod
		 public void setup(Method method) throws IOException {
		        test = extent.startTest(method.getName());
		        test.log(LogStatus.INFO, method.getName() + " test Started");
		        init(); // assumes this initializes WebDriver and page objects
		        openAppUrl();
		        PageFactory.initElements(driver, this);
			System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe"); 
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
	    driver.get("https://www.gladdensociety.org/jrgos-content-application/");
	}
	
	@Test
	public void negativessm() throws InterruptedException, AWTException, IOException {
		nsm = new ChangePasword(driver);
      	
      		WebDriverWait wait = new WebDriverWait(driver, 10);
    		WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='log in']")));

    		
    		  // Click the link 
    			loginLink.click();
    		  
    		  // Login details 
    			nsm.LoginByEmail(); nsm.PwdEmail(); nsm.SubmitEmail();
    		 
    		Thread.sleep(5000);
    		driver.get("https://www.gladdensociety.org/jrgos-content-application/");
    		 wait_for_page_load(5);
    		nsm.ssm();

	}

	 @AfterMethod
	    public void afterMethod(ITestResult result) {
	        get_result(result);
	    }	
	
}
	
