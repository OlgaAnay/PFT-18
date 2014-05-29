package com.example.tests;
import org.testng.annotations.Test;

public class ContactModificationTestNG extends TestBaseTestNG {

	@Test
	public void modifySomeContact()  throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editSomeContact(1);
//		app.getContactHelper().editRandomContact(app.getContactHelper().randomIndex);
	    
	    ContactData contact = new ContactData();
	    contact.lastname = "RRRRffrefewfModified Last Name";
		app.getContactHelper().editTable(contact);
		
		app.getContactHelper().updateContact();
		app.getContactHelper().gotoHomePage();
		

	
	}



	
}