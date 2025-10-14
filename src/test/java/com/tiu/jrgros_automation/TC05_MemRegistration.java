package com.tiu.jrgros_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.test_base.TestBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TC05_MemRegistration extends TestBase {

    WebDriver driver;

    @BeforeTest
    public void setup(Method result) throws IOException {
        test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		init(); // assumes this initializes WebDriver and page objects
		openAppUrl();
		PageFactory.initElements(driver, this);
		
		/*
		 * // System.setProperty("webdriver.chrome.driver",
		 * "D:\\VRUSHALI\\Eclipse\\JRGOS\\drivers\\chromedriver.exe"); driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.get("https://www.gladdensociety.org/join/");
		 */
    }

    @Test
    public void testJoinMembership() throws InterruptedException {
       

        Thread.sleep(2000); // Wait for the form to load

        // Select membership type (if dropdown exists, else skip)
        try {
            WebElement membershipDropdown = driver.findElement(By.xpath("//select[@name='pmpro_level']"));
            Select select = new Select(membershipDropdown);
            select.selectByVisibleText("Young Attending Membership $160.00 per Year.");
        } catch (Exception e) {
            System.out.println("Dropdown not found or not required.");
        }

        // Enter Email
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"bemail\"]"));
        emailField.sendKeys("vvrushaalivaidya@gmail.com");

        // Click Join button (adjust if multiple memberships exist)
        WebElement joinButton = driver.findElement(By.xpath("//*[@id=\"pmpro_btn-submit\"]"));
        joinButton.click();
        
        // You can fill other fields similarly (name, password, etc.) if required

		/*
		 * // Submit form WebElement submitBtn = driver.findElement(By.name("submit"));
		 * submitBtn.click();
		 */
        // Wait and validate
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
            currentUrl.contains("checkout") || currentUrl.contains("confirmation"),
            "Join flow did not redirect to checkout/confirmation."
        );
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}