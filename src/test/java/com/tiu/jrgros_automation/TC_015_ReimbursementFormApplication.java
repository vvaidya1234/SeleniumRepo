package com.tiu.jrgros_automation;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.*;
import com.tiu.test_base.TestBase;

public class TC_015_ReimbursementFormApplication extends TestBase {
	 	WebDriver driver;
	    WebDriverWait wait;
		ChangePasword rfa;
		
		 @BeforeMethod
		 public void setup(Method method) throws IOException {
		        test = extent.startTest(method.getName());
		        test.log(LogStatus.INFO, method.getName() + " test Started");
		        init(); // assumes this initializes WebDriver and page objects
		        openAppUrl();
		        PageFactory.initElements(driver, this);
		       	driver = new ChromeDriver(); 
		       	driver.manage().window().maximize();
		        driver.get("https://www.gladdensociety.org/reimbursement-form-application/#jrgos-sponsor");
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        }
		        
		  @Test
		  public void GrantForm() throws InterruptedException, AWTException {
			  rfa = new ChangePasword(driver);
			  WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement loginLink = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='log in']")));

				// Click the link
				loginLink.click();

				// Login details
				rfa.LoginByEmail();
				rfa.PwdEmail();
				rfa.SubmitEmail();

				Thread.sleep(5000);
				driver.get("https://www.gladdensociety.org/reimbursement-form-application/#jrgos-sponsor");
				rfa.GrantUploads();

	            // Submit the form
	          //  WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
	
}
		  @AfterMethod
		    public void afterMethod(ITestResult result) {
		        get_result(result);
		    }		  
}

