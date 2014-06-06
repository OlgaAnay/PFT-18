package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactModificationTestNG extends TestBaseTestNG {

	@Test
	public void modifySomeContact()  throws Exception {
		app.getNavigationHelper().openMainPage();

		//save state
		List<ContactData> oldList = app.getContactHelper().getContacts();		
		
		//actions
		
		app.getContactHelper().selectSomeContact(0); //this can be used for another condition
		//app.getContactHelper().editRandomContact(); //this can be used for another condition
	    ContactData contact = new ContactData();
	    contact.lastname = "RRRRffrefewfModified";
		app.getContactHelper().editTable(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().gotoHomePage();	
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare states		
		oldList.remove(0);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);		
	}	
}