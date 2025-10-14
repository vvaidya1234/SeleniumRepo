package com.tiu.jrgros_automation;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import com.tiu.jrgros_automation.*;
public class TC004_GSearch extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC004_GSearch.class.getName());

	/*
	 * @BeforeClass public static void startTest() { test =
	 * extent.startTest("TC004_GSearch");
	 * 
	 * }
	 */
	@BeforeMethod
	public void setup(Method result) throws IOException {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init(); // assumes this initializes WebDriver and page objects
		openAppUrl();
		PageFactory.initElements(driver, this);

		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init();
	}
	@AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
    }
}
