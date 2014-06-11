package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.entities.GroupData;

public class GroupRemoval extends TestBase {
	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteSomeGroup(GroupData group) {

		List<GroupData> oldList = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getGroupHelper().deleteGroup(index);

		List<GroupData> newList = app.getGroupHelper().getGroups();

		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
