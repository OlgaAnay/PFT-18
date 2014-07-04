package com.example.tests;

import static com.example.gldata.ContactDataGenerator.generateRandomContacts;
import static com.example.gldata.GroupDataGenerator.generateRandomGroups;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.entities.ContactData;
import com.example.entities.GroupData;
import com.example.fw.ApplicationManager;
import com.example.utils.Randomizer;

public class TestBase {

	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile",
				"firefox.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupDataForDataProvider(generateRandomGroups(2)).iterator();
	}

	public static List<Object[]> wrapGroupDataForDataProvider(
			List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[] { group });
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactDataForDataProvider(generateRandomContacts(2))
				.iterator();
	}

	public static List<Object[]> wrapContactDataForDataProvider(
			List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[] { contact });
		}
		return list;
	}

	public String generateRandomString() {
		return Randomizer.generateRandomString();
	}

	public String generateRandomPhone() {
		return Randomizer.generateRandomPhone();
	}
}