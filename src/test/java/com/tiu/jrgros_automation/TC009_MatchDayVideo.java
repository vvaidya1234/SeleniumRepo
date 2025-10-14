package com.tiu.jrgros_automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.tiu.test_base.TestBase;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.ChangePasword;
import java.time.*;

@Test
public class TC009_MatchDayVideo extends TestBase {

	public static final Logger log = Logger.getLogger(TC009_MatchDayVideo.class.getName());
 
	@BeforeClass

	public static void startTest() {
 
		test = extent.startTest("TC009_VideoSub_TestNew");
 
	}

	@BeforeMethod

	public void setup(Method result) throws IOException {

		test = extent.startTest(result.getName());

		test.log(LogStatus.INFO, result.getName() + " test Started");

		init();

	}	

	@Test(priority = 1, enabled = true)

	public void ProfilePcture() throws IOException, InterruptedException, AWTException {
 
		log.info("<===========Started Verifying ProfilePcture===========> ");

		openAppUrl();

		ChangePasword clp = new ChangePasword(driver);

		//wait_for_page_load(5);

		//waitInSeconds(10);

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
		  clp.VideoSubmit();
	
	}
}
