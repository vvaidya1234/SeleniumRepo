package com.tiu.jrgros_automation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tiu.all_action_driver.ActionDriver;
import com.tiu.test_base.TestBase;

public class TC02_ChangePwd extends TestBase {
    WebDriver driver;

    public static final Logger log = Logger.getLogger(TC02_ChangePwd.class.getName());

    @FindBy(id = "user-4dd5c2d")
    public static WebElement loginField;
    
    public void enterLogin() {
    	UpdatedActionDriver.click(driver, loginField);
    }
    @FindBy(id = "password-4dd5c2d")
    public static WebElement passwordField;
    
    public void enterpwd() {
    	UpdatedActionDriver.click(driver, passwordField);
    }
    
    @FindBy(name = "wp-submit")
    public static WebElement signInButton;
    public void submit() {
    	UpdatedActionDriver.click(driver, signInButton);
    }
    @FindBy(xpath = "//*[@id='password_current']")
    public WebElement CurrentPwd;
    
    public void pwdChange() {
    	UpdatedActionDriver.click(driver, CurrentPwd);
    }

    @FindBy(id = "pass1")
    public WebElement NewPwd;
    public void newPwdChange() {
    	UpdatedActionDriver.click(driver, NewPwd);
    }
 
    @FindBy(id = "pass2")
    public WebElement ConfirmPwd;
    public void confPwd() {
    	UpdatedActionDriver.click(driver, ConfirmPwd);
    }

    @FindBy(xpath = "//*[@id=\"change-password\"]/div[2]/input[1]")
    public WebElement ChangePasswordBtn;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement SuccessMessage;

    @BeforeClass
    public void setUp() {
    	
    	System.setProperty("webdriver.chrome.driver",
                "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gladdensociety.org/membership-dashboard/");
        driver.get("https://www.gladdensociety.org/membership-dashboard/member-profile-edit/?view=change-password");

        // Initialize all @FindBy annotated elements
        PageFactory.initElements(driver, this);
        
        loginField.sendKeys("vvaidya@tiuconsulting.com"); // replace with actual test user email
        passwordField.sendKeys("Tiu@gladden1");  
        signInButton.click();
        ActionDriver.scrollByVisibiltyOfElement(driver, CurrentPwd);
    }
    @Test
	public void testChangePassword() throws InterruptedException {
        try {
        	
        	CurrentPwd.sendKeys("Tiu@gladden1");
            NewPwd.sendKeys("Tiu@gladden2");
            ConfirmPwd.sendKeys("Tiu@gladden2");
            ChangePasswordBtn.click();

            // Wait and verify success message
            //Thread.sleep(3000); // Consider using WebDriverWait instead
            
            //WebDriverWait wait = new WebDriverWait(10, TimeUnit.SECONDS);
            
            //Assert.assertTrue(SuccessMessage.isDisplayed(), "Password change was not successful.");
            //Wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
            Assert.assertTrue(SuccessMessage.isDisplayed(), "Password change was not successful.");
            log.info("Password change successful.");

        	
        	
        	
        } catch (NoSuchElementException e) {
            log.error("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to missing element.");
        }
    }
}
 

    /*@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }*/
   
