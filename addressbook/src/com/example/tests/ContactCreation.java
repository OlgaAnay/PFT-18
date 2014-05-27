package com.example.tests;



import org.junit.*;



public class ContactCreation extends TestBase{
  @Test
  public void testContactCreation() throws Exception {
openMainPage();
openAddNew();
    //ContactData contacts = new ContactData("Test", "Testing", "INet", "123", "456", "789", "123@mail.ru", "456@mail.ru", "14", "September", "1991", "first group 1", "Inet2", "SPb");
ContactData contacts = new ContactData();
contacts.firstn = "Test";
contacts.lastn = "Testing";
contacts.hom = "Spb";
contacts.mob = "1235678901";
contacts.mail1 = "2@d.d";
contacts.addrr2 = "123";
contacts.adrr = "234";
contacts.mail2 = "3@h.r";
contacts.phone2 = "09876543212";
contacts.wor = "Work";
 
mon1 = selectMonth();
day1 = selectDay();
year1 = selectYear();
contacts.month = mon1;
contacts.day = day1;
contacts.year = year1;
    
newGroup1 = selectNewGroup();
contacts.newGroup = newGroup1;

editTable(contacts);
submitEdit();
gotoHomePage();
  }
}