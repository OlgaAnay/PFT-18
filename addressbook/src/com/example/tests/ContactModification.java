package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.entities.ContactData;
import com.example.utils.SortedListOf;

public class ContactModification extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) throws Exception {
		app.navigateTo().mainPage();

		SortedListOf<ContactData> oldList = app.getContactHelper()
				.getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		System.out.println("index " + index + " from " + oldList.size());

		app.getContactHelper().modifyContact(index, contact);

		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();

		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
}