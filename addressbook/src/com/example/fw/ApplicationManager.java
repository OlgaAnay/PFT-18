package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.example.models.ApplicationModel;

public class ApplicationManager {

	private static WebDriver driver;
	public static String baseUrl;

	private static NavigationHelper navigationHelper;
	private static GroupHelper groupHelper;
	private static ContactHelper contactHelper;
	private static Properties properties;
	private static HibernateHelper hibernateHelper;
	
	private ApplicationModel modelForGroups;
	private ApplicationModel modelForContacts;

	public ApplicationManager(Properties properties) {
		this.properties = properties;
		modelForContacts = new ApplicationModel();
		modelForContacts.setContacts(getHibernateHelper().listContacts());
		
		modelForGroups = new ApplicationModel();
		modelForGroups.setGroups(getHibernateHelper().listGroups());
		

	}
	
	public ApplicationModel getModelForGroups() {
		return modelForGroups;
	}

	public ApplicationModel getModelForContacts() {
		return modelForContacts;
	}
	
	public void stop() {
		driver.quit();
	}

	public NavigationHelper navigateTo() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}

	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

	public static WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null) {
			if ("firefox".equals(browser)) {
				driver = new FirefoxDriver();
			} else if ("ie".equals(browser)) {
				driver = new InternetExplorerDriver();
			} else {
				throw new Error("Unsupported browser" + browser);
			}

			baseUrl = properties.getProperty("baseURL");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl);
		}
		return driver;
	}

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
		
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
