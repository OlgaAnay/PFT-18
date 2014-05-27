package com.example.fw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.tests.TestBaseTestNG;

public class ApplicationManager {

	public static String baseUrl;
	public static WebDriver driver;
	public static boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	public static String day;
	public String mon1;
	public String day1;
	public String year1;
	public String mon;

	public String newGroup1;	
	
	public ApplicationManager() {

	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	} 
	public void stop() {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

	public void gotoHomePage() {
		driver.findElement(By.linkText("home page")).click();
	  
	}

	public String selectDay() {
		Random r = new Random();
		int a = r.nextInt(30) + 2;
		String day1 = driver.findElement(By.xpath("//select[@name=\"bday\"]/option[" + a + "]")).getText();
	    System.out.println("День: " + day1);
	
		return day1;
	
	}

	public String selectMonth(TestBaseTestNG testBaseTestNG) {
	      
	    String[] mon = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    int b = (int)(Math.random() * 12 );
		mon1 = mon[b];
		System.out.println("Месяц: " + mon1);
		
		return mon1;
	}

	public String selectYear() {
	
		int c = (int)(1970 + Math.random()*43);
		String year1 = String.valueOf(c);
	    System.out.println("Год: " + year1);
	
		return year1;
	
	}

	public String selectNewGroup(){
	
	int w = driver.findElements(By.xpath("//select[@name=\"new_group\"]/option")).size();
	System.out.println("Всего групп: "+ w);
	Random r = new Random();
	int a = r.nextInt(w)+1;
	System.out.println("Группа № "+ a);
	String newGroup1 = driver.findElement(By.xpath("//select[@name=\"new_group\"]/option["+ a +"]")).getText();
	System.out.println("Группа: " + newGroup1);
	
	return newGroup1;
	}

	public void submitEdit() {
		driver.findElement(By.name("submit")).click();
	   
	}

	public void openAddNew() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void returnToGroupsPage() {
	
	    driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
	
	    driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
	
		driver.findElement(By.name("new")).click();
	}

	public void gotoGroupsPage() {
	
		driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
	
		driver.get(baseUrl+"/addressbookv4.1.4/");
	}

}
