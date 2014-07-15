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

public class GroupModification extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupDataForDataProvider(loadGroupsXMLFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {

		//SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		SortedListOf<GroupData> oldList = app.getModelForGroups().getGroups();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getGroupHelper().modifyGroup(index, group);

		SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();

		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
