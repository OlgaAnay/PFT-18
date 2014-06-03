package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTestNG extends TestBaseTestNG {

  @Test
	  public void testContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openAddNew();

		//ContactData contacts = new ContactData("Test", "Testing", "INet", "123", "456", "789", "123@mail.ru", "456@mail.ru", "14", "September", "1991", "first group 1", "Inet2", "SPb");
		ContactData contact = new ContactData();
		contact.firstname = "Test";
		contact.lastname = "Testing";
		contact.home = "Spb";
		contact.mobile = "1235678901";
		contact.mail1 = "2@d.d";
		contact.address2 = "123";
		contact.address = "234";
		contact.mail2 = "3@h.r";
		contact.phone2 = "09876543212";
		contact.work = "Work";
		
		contact.month = app.getContactHelper().selectMonth(app);
		contact.day = app.getContactHelper().selectDay(app);
		contact.year = app.getContactHelper().selectYear(app);
		
		contact.newGroup = app.getContactHelper().selectNewGroup(app);
		
		app.getContactHelper().editTable(contact);
		app.getContactHelper().submitEdit();
		app.getContactHelper().gotoHomePage();
	  }

}