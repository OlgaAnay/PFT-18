package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTestNG extends TestBaseTestNG {

  @Test
  public void testContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save state
	List<ContactData> oldList = app.getContactHelper().getContacts();

	//actions
		
	app.getContactHelper().openAddNew();
		
	ContactData contact = new ContactData();
	contact.firstname = "aaa";
	contact.lastname = "Testing";
	contact.home = "Spb";
	contact.mobile = "1235678901";
	contact.mail1 = "2@d.d";
	contact.address2 = "123";
	contact.address = "234";
	contact.mail2 = "3@h.r";
	contact.phone2 = "09876543212";
	contact.work = "Work777";
		
	contact.month = app.getContactHelper().selectMonth(app);
	contact.day = app.getContactHelper().selectDay(app);
	contact.year = app.getContactHelper().selectYear(app);
		
	contact.newGroup = app.getContactHelper().selectNewGroup(app);
		
	app.getContactHelper().editTable(contact);
	app.getContactHelper().submitEdit();
	app.getContactHelper().gotoHomePage();
	
	//save new state	
	List<ContactData> newList = app.getContactHelper().getContacts();
	System.out.println("New: " + newList.toString());

	//compare states
	oldList.add(contact);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
	}
}