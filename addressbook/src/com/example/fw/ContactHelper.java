package com.example.fw;

import java.util.Random;
import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public String newGroup1;
	public static int randomIndex;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);	
	}
	
	public void deleteSelectedContact() {
		click(By.xpath("(//input[@name='update'])[2]"));	
	}
	public void updateContact() {
		click(By.name("update"));
	}
	
	public void editRandomContact() {
		int e = countElementsByXPath("//img[@alt=\"Edit\" and @title=\"Edit\"]");
		Random r = new Random();
		randomIndex = r.nextInt(e)+1;
		System.out.println("ri= "+randomIndex);
		click(By.xpath("(//img[@alt='Edit'])[" + randomIndex + "]"));	
	}
	public void selectSomeContact(int index) {
		click(By.xpath("//img[@alt=\"Edit\" and @title =\"Edit\"][" + (index+1) + "]"));	
	}
	  
	public void openAddNew() {
		click(By.linkText("add new"));
	}

	public void editTable(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
		type(By.name("lastname"),contact.lastname);
		type(By.name("address"),contact.address);
		type(By.name("home"),contact.home);
		type(By.name("mobile"),contact.mobile);
		type(By.name("work"),contact.work);
		type(By.name("email"),contact.mail1);
		type(By.name("email2"),contact.mail2);
	
		selectByText(By.name("bday"), contact.day);
		selectByText(By.name("bmonth"), contact.month);
	
		type(By.name("byear"),contact.year);
	
		selectByText(By.name("new_group"),contact.newGroup);
		
		type(By.name("address2"),contact.address2);
		type(By.name("phone2"),contact.phone2);
	}


	public String selectMonth(ApplicationManager applicationManager) {	      
	    String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    int b = (int)(Math.random() * 12 );
		String mon1 = month[b];
		System.out.println(mon1);
		
		return mon1;
	}

	public String selectDay(ApplicationManager applicationManager) {
		Random r = new Random();
		int a = r.nextInt(30) + 2;
		String day1 = findElementByText("//select[@name=\"bday\"]/option[" + a + "]");
	    System.out.println(day1);
	
		return day1;	
	}

	public String selectYear(ApplicationManager applicationManager) {	
		int c = (int)(1970 + Math.random()*43);
		String year1 = String.valueOf(c);
	    System.out.println(year1);
	
		return year1;
	}

	public void submitEdit() {
		click(By.name("submit"));
	}

	public String selectNewGroup(ApplicationManager applicationManager) {	
		int w = countElementsByXPath("//select[@name=\"new_group\"]/option");
		System.out.println( w);
		Random r = new Random();
		int a = r.nextInt(w)+1;
		System.out.println( a);
		newGroup1 = findElementByText("//select[@name=\"new_group\"]/option["+ a +"]");
		System.out.println( newGroup1);
		
		return newGroup1;
	}
	private String findElementByText(String locator) {
		return driver.findElement(By.xpath(locator)).getText();
	}

	private int countElementsByXPath(String locator) {
		return driver.findElements(By.xpath(locator)).size();
	}
	
	public void gotoHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

}
