package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			GroupData group = new GroupData().withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		app.navigateTo().mainPage();
		List<GroupData> groups = app.getGroupHelper().getGroups();
		int groupsAmount = groups.size();

		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			Random r = new Random();
			int randomGroupNumber = r.nextInt(groupsAmount);

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
					.withYear(Randomizer.selectYear())
					.withNewGroup(groups.get(randomGroupNumber).getName());
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		return Randomizer.generateRandomString();
	}

	public String generateRandomPhone() {
		return Randomizer.generateRandomPhone();
	}
}