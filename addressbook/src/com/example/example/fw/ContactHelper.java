package com.example.fw;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBaseTestNG;

public class ContactHelper extends HelperBase{
	public String day1;
	public String mon1;
	public String year1;
	public String newGroup1;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	
	}

	public void openAddNew() {
	click(By.linkText("add new"));
	}

	public void editTable(ApplicationManager applicationManager, TestBaseTestNG testBaseTestNG, ContactData contact) {
	type(By.name("firstname"),contact.firstname);
	type(By.name("lastname"),contact.lastname);
	type(By.name("address"),contact.address);
	type(By.name("lastname"),contact.lastname);
	type(By.name("home"),contact.home);
	type(By.name("mobile"),contact.mobile);
	type(By.name("work"),contact.work);
	type(By.name("email"),contact.mail1);
	type(By.name("email2"),contact.mail2);

	selectByText(By.name("bday"), contact.day);
	selectByText(By.name("bmonth"), contact.month);
	//new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.month);

	type(By.name("byear"),contact.year);

	//new Select(manager.driver.findElement(By.name("new_group"))).selectByVisibleText(contact.newGroup);
	
	type(By.name("address2"),contact.address2);
	type(By.name("phone2"),contact.phone2);

	}



	public String selectMonth(ApplicationManager applicationManager, TestBaseTestNG testBaseTestNG) {
	      
	    String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    int b = (int)(Math.random() * 12 );
		mon1 = month[b];
		System.out.println(mon1);
		
		return mon1;
	}

	public String selectDay(ApplicationManager applicationManager) {
		Random r = new Random();
		int a = r.nextInt(30) + 2;
		day1 = driver.findElement(By.xpath("//select[@name=\"bday\"]/option[" + a + "]")).getText();
	    System.out.println(day1);
	
		return day1;
	
	}

	public String selectYear(ApplicationManager applicationManager) {
	
		int c = (int)(1970 + Math.random()*43);
		year1 = String.valueOf(c);
	    System.out.println(year1);
	
		return year1;
	
	}

	public void submitEdit() {
	driver.findElement(By.name("submit")).click();
	}

	public String selectNewGroup(ApplicationManager applicationManager){
	
	
	int w = driver.findElements(By.xpath("//select[@name=\"new_group\"]/option")).size();
	System.out.println( w);
	Random r = new Random();
	int a = r.nextInt(w)+1;
	System.out.println( a);
	newGroup1 = driver.findElement(By.xpath("//select[@name=\"new_group\"]/option["+ a +"]")).getText();
	System.out.println( newGroup1);
	
	return newGroup1;
	}

	public void gotoHomePage() {
	driver.findElement(By.linkText("home page")).click();
	}

}
