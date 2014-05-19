package com.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {

	private static String baseUrl;
	private static WebDriver driver;
	protected String mon1;
	protected String day1;
	protected String year1;
	protected String newGroup1;
	private static StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/addressbookv4.1.4/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	protected String selectDay() {
		Random r = new Random();
		int a = r.nextInt(30) + 2;
		String day1 = driver.findElement(By.xpath("//select[@name=\"bday\"]/option[" + a + "]")).getText();
	    System.out.println("День: " + day1);
	
		return day1;
	
	}

	protected String selectMonth() {
	      
	    String[] mon = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    int b = (int)(Math.random() * 12 );
		mon1 = mon[b];
		System.out.println("Месяц: " + mon1);
		
		return mon1;
	}

	protected String selectYear() {
	
		int c = (int)(1970 + Math.random()*43);
		String year1 = String.valueOf(c);
	    System.out.println("Год: " + year1);

		return year1;
	
	}
	protected String selectNewGroup(){
    
	int w = driver.findElements(By.xpath("//select[@name=\"new_group\"]/option")).size();
    System.out.println("Всего групп: "+ w);
    Random r = new Random();
	int a = r.nextInt(w)+1;
	System.out.println("Группа № "+ a);
    String newGroup1 = driver.findElement(By.xpath("//select[@name=\"new_group\"]/option["+ a +"]")).getText();
    System.out.println("Группа: " + newGroup1);

	return newGroup1;
	}
	protected void gotoHomePage() {
		driver.findElement(By.linkText("home page")).click();
	    assertEquals("Address book", driver.getTitle());
	}

	protected void submitEdit() {
		driver.findElement(By.name("submit")).click();
	    assertEquals("Address book", driver.getTitle());
	}

	protected void editTable(ContactData contact) {
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(contact.firstn);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contact.lastn);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contact.adrr);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contact.hom);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contact.mob);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(contact.wor);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contact.mail1);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(contact.mail2);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.day);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.month);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contact.year);
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.newGroup);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contact.addrr2);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
	}

	protected void openAddNew() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void returnToGroupsPage() {
	
	    driver.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupCreation() {
	
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
	
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void initGroupCreation() {
	
		driver.findElement(By.name("new")).click();
	}

	protected void gotoGroupsPage() {
	
		driver.findElement(By.linkText("groups")).click();
	}

	protected void openMainPage() {
	
		driver.get(baseUrl+"/addressbookv4.1.4/");
	}


}

	