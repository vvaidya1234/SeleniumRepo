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
import com.tiu.page_object.ChangePasword;
import com.tiu.test_base.TestBase;

public class TC018_FellowshipGrantFormTest extends TestBase {
    WebDriver driver;
    WebDriverWait wait;
	ChangePasword gft;
	
	 @BeforeMethod
	    public void setup(Method result) throws IOException {
		   test = extent.startTest(result.getName());
	        test.log(LogStatus.INFO, result.getName() + " test Started");
	        init(); // assumes this initializes WebDriver and page objects
	        openAppUrl();
	        PageFactory.initElements(driver, this);
	       //System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe"); 
	       	driver = new ChromeDriver(); 
	       	driver.manage().window().maximize();
	        driver.get("https://www.gladdensociety.org/grants/2025-johnson-johnson-medtech-traveling-fellowship-grant-for-attendings-application/");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        }
	        
	  @Test
	  public void GrantForm() throws InterruptedException, AWTException {
		  gft = new ChangePasword(driver);
		  WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement loginLink = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='log in']")));

			// Click the link
			loginLink.click();
			Thread.sleep(5000);
			// Login details
			gft.LoginByEmail();
			gft.PwdEmail();
			gft.SubmitEmail();

			Thread.sleep(5000);
			driver.get("https://www.gladdensociety.org/grants/2025-johnson-johnson-medtech-traveling-fellowship-grant-for-attendings-application/");
			Thread.sleep(5000);
			gft.GrantUploads();
			Thread.sleep(5000);
            // Submit the form
           // WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
            //submitButton.click();
         
        }
	  @AfterMethod
	    public void afterMethod(ITestResult result) {
	        get_result(result);
	    }
    }
