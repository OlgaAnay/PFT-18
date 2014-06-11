package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.entities.ContactData;

public class ContactModification extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) throws Exception {
		app.navigateTo().mainPage();

		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		System.out.println("index " + index + " from " + oldList.size());
		
		app.getContactHelper().modifyContact(index, contact);

		List<ContactData> newList = app.getContactHelper().getContacts();

		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}