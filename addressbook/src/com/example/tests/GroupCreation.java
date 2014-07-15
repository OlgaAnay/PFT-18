package com.example.tests;

import static com.example.gldata.GroupDataGenerator.loadGroupsXMLFile;
import static com.example.gldata.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.entities.GroupData;
import com.example.utils.SortedListOf;

public class GroupCreation extends TestBase {

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupDataForDataProvider(loadGroupsXMLFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {

		//SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		SortedListOf<GroupData> oldList = app.getModelForGroups().getGroups();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		
		app.getGroupHelper().createGroup(group);

		SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();

		assertThat(newList, equalTo(oldList.withAdded(group)));
		
		if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(app.getModelForGroups().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
			}		
			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(app.getModelForGroups().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
			}
		}
	}
}
