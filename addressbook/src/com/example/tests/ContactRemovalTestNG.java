package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTestNG extends TestBaseTestNG {
	
	@Test
	public void removeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().selectSomeContact(0);
	    app.getContactHelper().deleteSelectedContact(); 
	}	
}
