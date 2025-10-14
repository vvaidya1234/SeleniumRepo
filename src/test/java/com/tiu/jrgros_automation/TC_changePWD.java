package com.tiu.jrgros_automation;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.*;

public class TC_changePWD extends TestBase {
    //WebDriver driver;
    ChangePasword cp;
    
    @BeforeMethod
    public void setup(Method method) throws IOException {
        test = extent.startTest(method.getName());
        test.log(LogStatus.INFO, method.getName() + " test Started");
        init(); // assumes this initializes WebDriver and page objects
        openAppUrl();
        PageFactory.initElements(driver, this);
    }
    
	/*
	 * private void launchApp() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Test
    public void TC_Login() throws InterruptedException 
    {
        //Thread.sleep(500);
        cp=new ChangePasword(driver);
        cp.enterLogin();
        cp.enterpwd();
        cp.submit();
        Thread.sleep(10000);
        cp.clickChangePassword();
        
        Thread.sleep(5000);
        cp.pwdChange();
        cp.newPwdChange();
        cp.confPwd();
        Thread.sleep(1000);
        cp.changePWDButton();
        Thread.sleep(5000);
        
        }
    
	 @AfterMethod
	    public void afterMethod(ITestResult result) {
	        get_result(result);
	    }	
}
