package com.example.fw;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {
	
	protected ApplicationManager manager;
	protected static WebDriver driver;
    public static boolean acceptNextAlert = true;
    
	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		driver = ApplicationManager.driver;
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null){
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}
	
	protected int countElements(By locator) {
		return driver.findElements(locator).size();
	} 

    private boolean isElementPresent(By by) {
        try {
         driver.findElement(by);
          return true;
        } catch (NoSuchElementException e) {
          return false;
        }
      }
    
      private String closeAlertAndGetItsText() {
        try {
          Alert alert = driver.switchTo().alert();
          String alertText = alert.getText();
          if (acceptNextAlert) {
            alert.accept();
          } else {
            alert.dismiss();
          }
          return alertText;
        } finally {
          acceptNextAlert = true;
        }
      }
	protected void type(By locator, String text) {
		if (text != null){
			driver.findElement(locator).clear();	
			driver.findElement(locator).sendKeys(text);
		}
		}
	protected void click(By locator) {
		driver.findElement(locator).click();
	}
}
