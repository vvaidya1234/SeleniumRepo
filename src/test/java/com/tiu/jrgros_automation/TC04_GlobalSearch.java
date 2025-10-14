package com.tiu.jrgros_automation;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tiu.test_base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


@Test
public class TC04_GlobalSearch extends TestBase {
	WebDriver driver;
//	public static final Logger log = Logger.getLogger(TC04_GlobalSearch.class.getName());
	
	
	/*
	 * @BeforeClass public static void startTest() { test =
	 * extent.startTest("TC04_GlobalSearch"); }
	 */
	    
		@BeforeMethod
		public void setup(Method result) throws IOException {
			
			System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe");

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.gladdensociety.org/");
	        
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName() + " test Started");
			init(); // assumes this initializes WebDriver and page objects
			openAppUrl();
			PageFactory.initElements(driver, this);
		}

    @FindBy(xpath = "//*[@id='opensearchbox']/i")
    private WebElement clickSearchIcon;

    @FindBy(xpath = "//*[@id='s']")
    private WebElement textSearch;

    @FindBy(xpath = "//*[@id='searchsubmit']")
    private WebElement btnSearch;

	/*
	 * @BeforeTest public void setUp() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\VRUSHALI\\Eclipse\\JRGOS\\drivers\\chromedriver.exe");
	 * 
	 * driver = new ChromeDriver(); driver.manage().window().maximize();
	 * driver.get("https://www.gladdensociety.org/");
	 * 
	 * // Initialize PageFactory elements PageFactory.initElements(driver, this); }
	 */
	@Test
    public void testGlobalSearch() throws InterruptedException {
        // Click search icon
        clickSearchIcon.click();
        Thread.sleep(2000); // Use WebDriverWait in real test

        // Enter text into the search field
        textSearch.sendKeys("membership");

        // Click search button
        btnSearch.click();
        Thread.sleep(2000); // Wait for results

        // Assertion to validate search result page
        //AssertJUnit.assertTrue(driver.getTitle().toLowerCase().contains("search"), "Search result page not loaded properly.");
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
    }
}