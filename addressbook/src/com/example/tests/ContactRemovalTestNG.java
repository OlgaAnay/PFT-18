package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTestNG extends TestBaseTestNG {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editSomeContact(1);
	    app.getContactHelper().deleteContact(); 

	}
	
}
