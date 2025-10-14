package com.tiu.jrgros_automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UpdatedActionDriver {
          public static void scrollByVisibiltyOfElement(WebDriver driver, WebElement ele) {
              JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].scrollIntoView({block: 'center'})", ele);
          }

          
          
          public static void click(WebDriver ldriver, WebElement locatorName) {
              Actions act = new Actions(ldriver);
              act.moveToElement(locatorName).click().build().perform();

          }
          
         
          
          
          
         

}
