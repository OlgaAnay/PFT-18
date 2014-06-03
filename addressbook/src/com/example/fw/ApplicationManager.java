package com.example.fw;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	
	protected static WebDriver driver;
	public static String baseUrl;

	
	private static NavigationHelper navigationHelper;
 	private static GroupHelper groupHelper; 
 	private static ContactHelper contactHelper;
 	
	public ApplicationManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
	}
	
	public void stop() {
		driver.quit();
	}

	public NavigationHelper getNavigationHelper() {
		if (navigationHelper == null){
			navigationHelper = new NavigationHelper(this);
		}
			return navigationHelper;	
	}
	
	public GroupHelper getGroupHelper() {
		if (groupHelper == null){
			groupHelper = new GroupHelper(this);
		}
			return groupHelper;	
	}
	public ContactHelper getContactHelper() {
		if (contactHelper == null){
			contactHelper = new ContactHelper(this);
		}
			return contactHelper;	
	}
      }    