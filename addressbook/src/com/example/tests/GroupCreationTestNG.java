package com.example.tests;


import org.testng.annotations.Test;

public class GroupCreationTestNG extends TestBaseTestNG {

  @Test
  public void testGroupCreationNotEmpty() throws Exception {
	openMainPage();
	gotoGroupsPage();
	initGroupCreation();
	GroupData group = new GroupData("first group 1", "header 1", "footer 1");
	group.name="first group 1";
	group.header="header 1";
	group.footer="footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();

  }
  @Test
  public void testGroupCreationEmpty() throws Exception {
	openMainPage();
	gotoGroupsPage();
	initGroupCreation();
	fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();

  }

}
