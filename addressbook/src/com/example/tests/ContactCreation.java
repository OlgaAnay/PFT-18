package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.entities.ContactData;
import com.example.utils.SortedListOf;

public class ContactCreation extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreation(ContactData contact) throws Exception {
		app.navigateTo().mainPage();

		SortedListOf<ContactData> oldList = app.getContactHelper()
				.getContacts();

		app.getContactHelper().createContact(contact);

		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();
		System.out.println("New List: " + newList.toString());

		assertThat(newList, equalTo(oldList.withAdded(contact)));
	}
}