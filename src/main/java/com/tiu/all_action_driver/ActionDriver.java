package com.tiu.all_action_driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionDriver {
	public static Object uploadMultipleFiles;

	public static boolean selectBysendKeys(WebElement ele, String value) throws Throwable {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from dropdown");
			} else {
				System.out.println("Not Selected value from the DropDown");
			}
		}
	}

	public static void scrollByVisibiltyOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'})", ele);
	}

	public static void click(WebDriver ldriver, WebElement locatorName) {
		Actions act = new Actions(ldriver);
		act.moveToElement(locatorName).click().build().perform();

	}

	public static void uploadMultipleFiles(WebElement uploadElement, String[] filePaths) {
		try {
			// Join all file paths using newline separator
			String files = String.join("\n", filePaths);
			// Send to the input element
			uploadElement.sendKeys(files);
		} catch (Exception e) {
			System.out.println("Error while uploading files: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
