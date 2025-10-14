package com.tiu.jrgros_automation;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.ChangePasword;
import com.tiu.test_base.TestBase;

public class TC06_ResetPassword extends TestBase {
	 //WebDriver driver;
    ChangePasword cp;
    public static final Logger log = Logger.getLogger(TC02_ChangePwd.class.getName());

    @FindBy(xpath = "//span[contains(text(),'Reset Password')]")
    public static WebElement ResetPass;
    
    public void enterResetPwd() {
    	UpdatedActionDriver.click(driver, ResetPass);
    }
    @FindBy(id = "user_login")
    public static WebElement Resetemail;
    
    public void enterPwdAdd() {
    	UpdatedActionDriver.click(driver, Resetemail);
    }
    @FindBy(xpath = "//input[@name='submit']")
    public static WebElement ResetGetNewPwdBtn;
    
    public void enterGetPwdbtn() {
    	UpdatedActionDriver.click(driver, ResetGetNewPwdBtn);
    	}
    @BeforeMethod
    public void setup(Method method) throws IOException {
    	test = extent.startTest(method.getName());
        test.log(LogStatus.INFO, method.getName() + " test Started");
        init(); // assumes this initializes WebDriver and page objects
        openAppUrl();
        PageFactory.initElements(driver, this);
    	System.setProperty("webdriver.chrome.driver",
                "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://www.gladdensociety.org/");
        
    }
	@Test
    public void TC_Login() throws InterruptedException 
    {
		ChangePasword cp = new ChangePasword(driver);
		//clp.clientSignIn(OR.getProperty("emailID1"), OR.getProperty("createAccountPassword1"));
		wait_for_page_load(5);
		waitInSeconds(10);
        //Thread.sleep(5000);
        ResetPass.click();
        Thread.sleep(5000);
        Resetemail.sendKeys("vvaidya@tiuconsulting.com");
        Thread.sleep(5000);
        ResetGetNewPwdBtn.click();
        cp.accessGmail();
        }
    
	 @AfterMethod
	    public void afterMethod(ITestResult result) {
	        get_result(result);
	    }	

}
