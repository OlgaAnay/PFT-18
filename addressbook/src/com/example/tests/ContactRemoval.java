package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.entities.ContactData;

public class ContactRemoval extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void removeContact(ContactData contact) {
		app.navigateTo().mainPage();

		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		 //app.getContactHelper().deleteAllContacts(); // it sometimes useful
		app.getContactHelper().removeContact(index);

		List<ContactData> newList = app.getContactHelper().getContacts();

		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
