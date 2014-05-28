package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTestNG extends TestBaseTestNG {

  @Test
  public void testContactCreation() throws Exception {
app.getNavigationHelper().openMainPage();
app.getContactHelper().openAddNew();
//ContactData contacts = new ContactData("Test", "Testing", "INet", "123", "456", "789", "123@mail.ru", "456@mail.ru", "14", "September", "1991", "first group 1", "Inet2", "SPb");
ContactData contacts = new ContactData();
contacts.firstname = "Test";
contacts.lastname = "Testing";
contacts.home = "Spb";
contacts.mobile = "1235678901";
contacts.mail1 = "2@d.d";
contacts.address2 = "123";
contacts.address = "234";
contacts.mail2 = "3@h.r";
contacts.phone2 = "09876543212";
contacts.work = "Work";

app.getContactHelper().mon1 = app.getContactHelper().selectMonth(app, this);
app.getContactHelper().day1 = app.getContactHelper().selectDay(app);
app.getContactHelper().year1 = app.getContactHelper().selectYear(app);
contacts.month = app.getContactHelper().mon1;
contacts.day = app.getContactHelper().day1;
contacts.year = app.getContactHelper().year1;

app.getContactHelper().newGroup1 = app.getContactHelper().selectNewGroup(app);
contacts.newGroup = app.getContactHelper().newGroup1;

app.getContactHelper().editTable(app, this, contacts);
app.getContactHelper().submitEdit();
app.getContactHelper().gotoHomePage();
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