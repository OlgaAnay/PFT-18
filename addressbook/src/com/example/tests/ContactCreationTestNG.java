package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTestNG extends TestBaseTestNG {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save state
	List<ContactData> oldList = app.getContactHelper().getContacts();

	//actions
		
	app.getContactHelper().openAddNew();
	app.getContactHelper().editTable(contact);
	app.getContactHelper().submitEdit();
	app.getContactHelper().gotoHomePage();
	
	//save new state	
	List<ContactData> newList = app.getContactHelper().getContacts();
	System.out.println("New List: " + newList.toString());

	//compare states
	oldList.add(contact);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
	}
}