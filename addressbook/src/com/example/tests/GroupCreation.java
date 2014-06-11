package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.entities.GroupData;

public class GroupCreation extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {

		List<GroupData> oldList = app.getGroupHelper().getGroups();

		app.getGroupHelper().createGroup(group);

		List<GroupData> newList = app.getGroupHelper().getGroups();

		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
