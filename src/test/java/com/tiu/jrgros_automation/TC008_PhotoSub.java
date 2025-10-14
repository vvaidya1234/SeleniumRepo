package com.tiu.jrgros_automation;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.ChangePasword;
import com.tiu.test_base.TestBase;

public class TC008_PhotoSub extends TestBase {
	
   // WebDriver driver;
    ChangePasword syp;
    
	/*
	 * @FindBy(id = "user-4dd5c2d") public static WebElement loginField;
	 * 
	 * @FindBy(id = "password-4dd5c2d") public static WebElement passwordField;
	 * 
	 * // @FindBy(xpath = "//button[@name='wp-submit']")
	 * 
	 * @FindBy(name = "wp-submit") public static WebElement signInButton;
	 */
    

    @BeforeMethod
    	 public void setup(Method method) throws InterruptedException, IOException {
 	        test = extent.startTest(method.getName());
 	        test.log(LogStatus.INFO, method.getName() + " test Started");
 	        init(); // assumes this initializes WebDriver and page objects
 	       //driver.get("https://www.gladdensociety.org/photo-submission/");
 	        openAppUrl();
 	        PageFactory.initElements(driver, this);
    	//System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe");
        // Set your ChromeDriver path if needed
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.gladdensociety.org/photo-submission-application/");
    }

    @Test
    public void fillPhotoSubmissionForm() throws InterruptedException {
		
		  try { Thread.sleep(5000);
		  }
		  catch (InterruptedException e) {
			  // TODO Auto-generated catch block 
			  e.printStackTrace(); }
		 
    	syp = new ChangePasword(driver);
    	syp.findSubmitYourPhotos();
    	   // Submit Your Photos
       // driver.findElement(By.xpath("//*[@id=\"loginrequred\"]")).click();
   
    	
        // Check if login is required (e.g., by checking login form or URL redirect)
        if (driver.getCurrentUrl().contains("login") || driver.findElements(By.xpath("//*[@id=\"loginmyModal_s\"]/div/div")).size() > 0) {
            performLogin("vvaidya@tiuconsulting.com", "Tiu@gladden1");
         syp.enterUsername();
         syp.enterpwpasswordd();
         syp.submitBtn();
         WebDriverWait wait = new WebDriverWait(driver, (20));
         wait.until(ExpectedConditions.urlContains("dashboard")); 
        driver.get("https://www.gladdensociety.org/photo-submission-application/");
         Thread.sleep(20);
         syp.FirstName();
         syp.LastName();
         syp.EmailPhoto();
         syp.AffilateWithJRGOS();
         syp.PhotoDescription();
         syp.PhotoLoc();
         syp.PhotoUp();
         Thread.sleep(10);
         syp.PhotoCaption();
         syp.CheckBox();
         syp.PhotoSubmit();
         Thread.sleep(10);
        }

       
		  // Fill in required text fields
	//	Pending from here...from..from...from..from..from..from..from..from.
		  
		  // Upload a photo WebElement uploadInput =
			/*
			 * driver.findElement(By.id("photo-upload"));
			 * uploadInput.sendKeys("C:\\Users\\Admin\\OneDrive\\Pictures\\download (2).jpg"
			 * );
			 * 
			 * // Agree to terms WebElement checkbox =
			 * driver.findElement(By.id("terms-checkbox")); if (!checkbox.isSelected()) {
			 * checkbox.click(); }
			 */

		
			/*
			 * // Submit
			 * driver.findElement(By.xpath("//*[@id=\"wpforms-submit-3093\"]")).click();
			 */
      
    }

	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */
    @AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
}


	private void performLogin(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}