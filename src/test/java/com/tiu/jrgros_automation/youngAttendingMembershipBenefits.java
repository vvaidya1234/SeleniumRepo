package com.tiu.jrgros_automation;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.test_base.TestBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Test
public class youngAttendingMembershipBenefits extends TestBase {
	/*
	 * FindBy(xpath=
	 * "/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div/div/h3") WebElement
	 * title
	 * 
	 * FindBy(xpath=
	 * "/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div/div/ul") WebElement
	 * content
	 */
	//.......................................
	
	    WebDriver driver;

	    @BeforeMethod
	    public void setup(Method method) throws InterruptedException, IOException {
	    	        test = extent.startTest(method.getName());
	    	        test.log(LogStatus.INFO, method.getName() + " test Started");
	    	        init(); // assumes this initializes WebDriver and page objects
	    	        openAppUrl();
	    	        PageFactory.initElements(driver, this);
					/*
					 * System.setProperty("webdriver.chrome.driver",
					 * "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe");
					 */
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	       // waitInSeconds(15);
	    }

	    public void verifyMembershipBenefitsOrder() throws InterruptedException {
	        driver.get("https://www.gladdensociety.org/young-attending-membership-benefits/");
	        waitInSeconds(15);

	        // Update the selector as per the actual benefit items, here assuming <li> tags in a section
	        List<WebElement> benefitElements = driver.findElements(By.cssSelector(".elementor-image-box-title"));

	        // Extract text from each benefit element
	        List<String> actualBenefits = benefitElements.stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());

	        // Define the expected sequence of benefit texts
	        List<String> expectedBenefits = Arrays.asList(
	        		"Young Attending Benefits (0-5 yrs)",
	        		"Board prep ABOS 1 & 2 course support",
	        		"Mock Oral ABOS2 Exam program",
	        		"Access to JRGOS Members Only Online Platform",
	        		"Access to research grants and clinical grants & trials",
	        		"Mentorship programs",
	        		"Annual and regional meetings",
	        		"Access to JRGOS programs",
	        		"Access to JRGOS Newsletters and Publications",
	        		"Clinical and Research Fellowship resources",
	        		"Committee and leadership opportunities",
	        		"Advocacy opportunities",
	        		"Volunteer opportunities"
	        		/*"Traveling Attending Fellowships",
	        		"Access to a range of knowledge from podcast, seminars, and continuing education",
	        		"Invitation to the Annual Luncheon & other JRGOS programs",
	        		"Access to job boards",
	        		"Networking opportunities",
	        		"Community engagement",
	        		"Discount for meeting attendance"*/
	        );

	        Assert.assertEquals(actualBenefits, expectedBenefits, "Benefits are not in the expected sequence.");
	        
	    }

		/*
		 * @AfterClass{ public void teardown() { driver.quit(); }
		 */
	    @AfterMethod
	    public void afterMethod(ITestResult result) {
	        get_result(result);
	}
	    }

