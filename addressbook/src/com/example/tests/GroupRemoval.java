package com.example.tests;

import static com.example.gldata.GroupDataGenerator.loadGroupsXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.entities.GroupData;
import com.example.utils.SortedListOf;

public class GroupRemoval extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupDataForDataProvider(loadGroupsXMLFile(new File("groups.xml"))).iterator();
	}
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteSomeGroup(GroupData group) {

		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getGroupHelper().deleteGroup(index);

		SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();

		assertThat(newList, equalTo(oldList.without(index)));
	}
}
