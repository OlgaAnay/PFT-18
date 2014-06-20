package com.example.gldata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.entities.ContactData;
import com.example.entities.GroupData;
import com.example.utils.Randomizer;
import com.thoughtworks.xstream.XStream;
import com.example.fw.ApplicationManager;

public class ContactDataGenerator {

	protected static ApplicationManager app;
	
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("Please, specify parameters: <amount of test data> <file> <format>. ");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File already exists " + file);
			return;
		}
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsXMLFile(contacts, file);
		} else {
			System.out.println("Unknowm format: " + format);
			return;
		}
	}

	private static void saveContactsXMLFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", GroupData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}

	private static void saveContactsCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write( contact.getFirstname() + "," + contact.getLastname() + ","
						+ contact.getAddress() + "," + contact.getAddress2() + ","
						+ contact.getDay() + "," + contact.getMonth() + ","
						+ contact.getYear() + "," + contact.getHome() + ","
						+ contact.getMail1() + "," + contact.getMail2() + ","
						+ contact.getMobile() + ","	+ contact.getPhone2() + ","
						+ contact.getWork() + "," + contact.getNewGroup() + ",|" + "\n");
		}
		writer.close();		
	}

	public static List<ContactData> generateRandomContacts(int amount) {

	/*		app.navigateTo().mainPage();
			List<GroupData> groups = app.getGroupHelper().getGroups();
			int groupsAmount = groups.size();

			List<ContactData> list = new ArrayList<ContactData>();
			for (int i = 0; i < amount; i++) {
				Random r = new Random();
				int randomGroupNumber = r.nextInt(groupsAmount);
*/
		
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {		
	
			ContactData contact = new ContactData()
					.withFirstname(generateRandomString())
					.withLastname(generateRandomString())
					.withMobile(generateRandomPhone())
					.withMail1(generateRandomString())
					.withAddress2(generateRandomString())
					.withAddress(generateRandomString())
					.withMail2(generateRandomString())
					.withPhone2(generateRandomPhone())
					.withWork(generateRandomString())
					.withMonth(Randomizer.selectMonth())
					.withDay(Randomizer.selectDay())
					.withYear(Randomizer.selectYear());
				//	.withNewGroup(groups.get(randomGroupNumber).getName());
			list.add(contact);
		}
		return list;
	}
	
	public static String generateRandomString() {
		return Randomizer.generateRandomString();
	}

	public static String generateRandomPhone() {
		return Randomizer.generateRandomPhone();
	}
}
