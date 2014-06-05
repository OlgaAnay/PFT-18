package com.example.tests;
import org.testng.annotations.Test;

public class ContactModificationTestNG extends TestBaseTestNG {

	@Test
	public void modifySomeContact()  throws Exception {
		app.getNavigationHelper().openMainPage();
		//app.getContactHelper().selectSomeContact(0); //this can be used for another condition
		app.getContactHelper().editRandomContact();
	    ContactData contact = new ContactData();
	    contact.lastname = "RRRRffrefewfModified Last Name";
		app.getContactHelper().editTable(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().gotoHomePage();	
	}	
}