package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTestNG extends TestBaseTestNG {

  @Test
	  public void testGroupCreationNotEmpty() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData("first group 1", "header 1", "footer 1");
		group.name="first group 1";
		group.header="header 1";
		group.footer="footer 1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
  	}
  
  @Test
  	public void testGroupCreationEmpty() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
  }

}
