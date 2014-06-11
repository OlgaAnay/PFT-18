package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.entities.GroupData;
import com.example.utils.SortedListOf;

public class GroupRemoval extends TestBase {
	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteSomeGroup(GroupData group) {

		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getGroupHelper().deleteGroup(index);

		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		assertThat(newList, equalTo(oldList.without(index)));
	}
}
