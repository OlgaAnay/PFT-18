package com.example.tests;

import static com.example.gldata.ContactDataGenerator.loadContactsXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.entities.ContactData;
import com.example.utils.SortedListOf;

public class ContactRemoval extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactDataForDataProvider(loadContactsXMLFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "randomValidContactGenerator")
	public void removeContact(ContactData contact) {
		app.navigateTo().mainPage();

		SortedListOf<ContactData> oldList = app.getContactHelper()
				.getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// app.getContactHelper().deleteAllContacts(); // it sometimes useful
		app.getContactHelper().removeContact(index);

		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();

		assertThat(newList, equalTo(oldList.without(index)));
	}
}
