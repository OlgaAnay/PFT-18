package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.entities.GroupData;
import com.example.utils.SortedListOf;

public class GroupCreation extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {

		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		app.getGroupHelper().createGroup(group);

		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		assertThat(newList, equalTo(oldList.withAdded(group)));
	}
}
