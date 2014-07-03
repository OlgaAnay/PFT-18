package com.example.tests;

import static com.example.gldata.ContactDataGenerator.loadContactsXMLFile;
import static com.example.gldata.ContactDataGenerator.loadContactsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.entities.ContactData;
import com.example.utils.SortedListOf;

public class ContactCreation extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactDataForDataProvider(loadContactsXMLFile(new File("contacts.xml"))).iterator();
	}
	
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