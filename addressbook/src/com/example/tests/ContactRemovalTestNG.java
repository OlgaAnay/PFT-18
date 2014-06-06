package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactRemovalTestNG extends TestBaseTestNG {
	
	@Test
	public void removeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save state
		List<ContactData> oldList = app.getContactHelper().getContacts();		
			
		//actions
		//app.getContactHelper().deleteAllContacts(); // it sometime usefull
		app.getContactHelper().selectSomeContact(0);
	    app.getContactHelper().deleteSelectedContact(); 
		app.getContactHelper().gotoHomePage();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();		
		
		//compare states
		oldList.remove(0);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}	
}
