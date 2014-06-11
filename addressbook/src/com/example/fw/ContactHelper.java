package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.entities.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	public static int randomIndex;
	public static String newGroup;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);	
	}
	
		public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		openAddNew();
		editTable(contact, ContactHelper.CREATION);
		submitEdit();
		gotoHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		selectSomeContact(index);
		// editRandomContact(); //this can be used for another condition
		editTable(contact, ContactHelper.MODIFICATION).updateContact();
		gotoHomePage();
		rebuildCache();
		return this;
	}
	

	public ContactHelper removeContact(int index) {
		if (countContacts() != 0) {
		selectSomeContact(index);
		deleteSelectedContact();
		gotoHomePage();
		rebuildCache();
		}
		return this;
	}
	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
			if(cachedContacts == null) {
				rebuildCache();
			}
		return cachedContacts;
	}
	
	private void rebuildCache() {
		manager.navigateTo().mainPage();
		cachedContacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes){

			String title = checkbox.getAttribute("title");
			String fn = title.substring("Select (".length(),title.length() - ")".length());
			String firstname = fn.substring(0, fn.indexOf(" "));		
			String lastname = fn.substring(fn.indexOf(" ") + 1);
			cachedContacts.add(new ContactData()
					.withFirstname(firstname)
					.withLastname(lastname));
		}
	}
	
	public int countContacts() {
		return countElements(By.name("selected[]"));
	}

//-------------------------------------------------------	
	public ContactHelper deleteSelectedContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		rebuildCache();
		return this;
	}
	public ContactHelper updateContact() {
		click(By.name("update"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper editRandomContact() {
		int e = countElements(By.xpath("//img[@alt=\"Edit\" and @title=\"Edit\"]"));
		Random r = new Random();
		randomIndex = r.nextInt(e)+1;
		System.out.println("ri= "+randomIndex);
		click(By.xpath("(//img[@alt='Edit'])[" + randomIndex + "]"));	
		return this;
	}
	
	public ContactHelper selectSomeContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}
	  
	public ContactHelper deleteAllContacts() {
		if (countContacts() != 0) {
		selectContactAndDeleteIt();
		rebuildCache();
		}	
		return this;
	}
	
	public ContactHelper selectContactAndDeleteIt() {
		int w = countContacts(); //countElements(By.xpath("//img[@alt='Edit' and @title ='Edit']"));
		System.out.println("Contacts = " + w);
		for (int index = 1; index <= w; index++){
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));
		deleteSelectedContact();
		gotoHomePage();
		rebuildCache();
		}
		return this;
	}
	public ContactHelper openAddNew() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper editTable(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getMail1());
		type(By.name("email2"), contact.getMail2());
	
		selectByText(By.name("bday"), contact.getDay());
		selectByText(By.name("bmonth"), contact.getMonth());
	
		type(By.name("byear"), contact.getYear());
		if (formType == CREATION) {	
			selectByText(By.name("new_group"), contact.getNewGroup());
		} else {
			if (countElements(By.name("new_group")) != 0){
				throw new Error ("Group selector exists in contact modification form. ");
			}
		}
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	public ContactHelper submitEdit() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public void selectNewGroup() {	
			int w = countElements(By.xpath("//select[@name='new_group']/option"));
			System.out.println("How many groups now: " + w);
			Random r = new Random();
			int a = r.nextInt(w)+1;
			System.out.println(a);
			selectByIndex(By.xpath("//select[@name='new_group']"), a);
	}
	
	public ContactHelper gotoHomePage() {
		click(By.linkText("home page"));
		return this;
	}
}
