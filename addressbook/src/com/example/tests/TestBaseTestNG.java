package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBaseTestNG {

protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i =0; i<2; i++){
			GroupData group = new GroupData();	
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();		
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i =0; i<3; i++){
			ContactData contact = new ContactData();	
			contact.firstname = generateRandomString();
			contact.lastname = generateRandomString();
			contact.home = generateRandomString();
			contact.mobile = generateRandomString();
			contact.mail1 = generateRandomString();
			contact.address2 = generateRandomString();
			contact.address = generateRandomString();
			contact.mail2 = generateRandomString();
			contact.phone2 = generateRandomString();
			contact.work = generateRandomString();
			
			contact.month = app.getContactHelper().selectMonth(app);
			contact.day = app.getContactHelper().selectDay(app);
			contact.year = app.getContactHelper().selectYear(app);
			
			//contact.newGroup = app.getContactHelper().selectNewGroup(app); // I don't know what to do with selecting of random group.
																				
																			// If to re-comment this string, it wont work. Why? 
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();		
			if (rnd.nextInt(3) == 0){
				return "";
			} else {
				return "test" + rnd.nextInt();
			}
	}
}
