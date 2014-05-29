package com.example.tests;
import org.testng.annotations.Test;

public class GroupRemovalTestNG extends TestBaseTestNG{
@Test
public void deleteSomeGroup(){
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();
	app.getGroupHelper().deleteGroup(1);
	app.getGroupHelper().returnToGroupsPage();
}
}
