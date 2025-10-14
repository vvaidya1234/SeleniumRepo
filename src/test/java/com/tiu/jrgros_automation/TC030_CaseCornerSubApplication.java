package com.tiu.jrgros_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tiu.page_object.ChangePasword;

import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class TC030_CaseCornerSubApplication {
    WebDriver driver;
    WebDriverWait wait;
	ChangePasword ccs;

    @BeforeMethod
    public void setup() {
       System.setProperty("webdriver.chrome.driver", "D:\\VRUSHALI\\Eclipse\\jrgross\\drivers\\chromedriver.exe"); 
       	driver = new ChromeDriver(); 
       	driver.manage().window().maximize();
        driver.get("https://www.gladdensociety.org/jrgos-case-corner-submission-application/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
    }

    @Test
    public void fillCaseCornerSubmissionForm() throws InterruptedException, AWTException {

    	ccs = new ChangePasword(driver);
		// Wait for the link to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement loginLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='log in']")));

		// Click the link
		loginLink.click();

		// Login details
		ccs.LoginByEmail();
		ccs.PwdEmail();
		ccs.SubmitEmail();

		Thread.sleep(5000);
		driver.get("https://www.gladdensociety.org/jrgos-case-corner-submission-application/");
		ccs.caseCornerSub();
		//ccs.orgDropdown();
		//ccs.org2ndDropdown();
		//ccs.org3rdDropdown();

        // 📎 Uploading Case File
        /*WebElement fileUpload = driver.findElement(By.name("upload-case-file"));
        fileUpload.sendKeys("\"C:\\Users\\Admin\\OneDrive\\Desktop\\Invoice-20250416-072753.pdf\"");  // Ensure valid path on your system

        // 🔘 Consent Checkbox
        WebElement consent = driver.findElement(By.name("consent-checkbox"));
        if (!consent.isSelected()) {
            consent.click();
        }

        // ✅ Submit Form
       // driver.findElement(By.cssSelector("form button[type='submit']")).click();

        // 🟢 Assertion on Confirmation
        WebElement confirmation = driver.findElement(By.className("wpcf7-mail-sent-ok"));
        Assert.assertTrue(confirmation.isDisplayed(), "Form submission failed or confirmation not found.");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }*/
    }
}