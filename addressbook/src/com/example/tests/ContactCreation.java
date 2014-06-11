package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.entities.ContactData;

public class ContactCreation extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreation(ContactData contact) throws Exception {
		app.navigateTo().mainPage();

		List<ContactData> oldList = app.getContactHelper().getContacts();

		app.getContactHelper().createContact(contact);

		List<ContactData> newList = app.getContactHelper().getContacts();
		System.out.println("New List: " + newList.toString());

		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}