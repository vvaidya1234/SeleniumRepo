package com.tiu.jrgros_automation;

import java.awt.AWTException;

import java.io.IOException;

import java.lang.reflect.Method;
 
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
 
import com.tiu.page_object.ChangePasword;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
 
 
	public class TC009_VideoSub_TestNew extends TestBase {

		public static final Logger log = Logger.getLogger(TC009_VideoSub_TestNew.class.getName());
		
		/*
		 * @BeforeClass
		 * 
		 * public static void startTest() {
		 * 
		 * test = extent.startTest("TC009_VideoSub_TestNew");
		 * 
		 * }
		 */
		  
		@BeforeMethod

		public void setup(Method result) throws IOException {

			test = extent.startTest(result.getName());

			test.log(LogStatus.INFO, result.getName() + " test Started");

			init();
			PageFactory.initElements(driver, this);
	    	System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe");
	        // Set your ChromeDriver path if needed
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.gladdensociety.org/match-day-video-submission/");
		}	

		@Test(priority = 1, enabled = true)

		public void ProfilePcture() throws IOException, InterruptedException, AWTException {
			ChangePasword clp = new ChangePasword(driver);

			//wait_for_page_load(5);
			

			//waitInSeconds(10);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
		//	log.info("<===========Started Verifying ProfilePcture===========> ");

			/*
			 * openAppUrl(); Thread.sleep(5000);
			 */
			
			/*
			 * WebElement loginLink =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
			 * xpath("//a[normalize-space()='log in']")));
			 * 
			 * 
			 * // Click the link loginLink.click();
			 * 
			 * // Login details clp.LoginByEmail(); clp.PwdEmail(); clp.SubmitEmail();
			 */
    		 
    		Thread.sleep(5000);
			clp.submissin();
			wait_in_seconds(10);
			
			  clp.PrefixMatch(); 
			  clp.MedicalSchool(); 
			  clp.VideoFName(); 
			  clp.VideoLName();
			  clp.VideoMatch(); 
			  clp.VideoSuffix(); 
			  clp.VideoEmail();
			  clp.VideoRedioSelection(); 
			  clp.VideoFacebook(); 
			  clp.VideoInstagram();
			  clp.VideoYoutube(); 
			  clp.VideoX(); 
			  //clp.VideoSubmit();
			 
			

		}


		


	}
	 


