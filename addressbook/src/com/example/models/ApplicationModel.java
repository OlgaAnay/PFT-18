package com.example.models;

import java.util.List;

import com.example.entities.ContactData;
import com.example.entities.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<GroupData> groups;
	private SortedListOf<ContactData> contacts;
	
	public SortedListOf<GroupData> getGroups() {
		return groups;
	}
	
	public void setGroups(List<GroupData> groups) {
		this.groups = new SortedListOf<GroupData>(groups);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}
	
	public SortedListOf<ContactData> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<ContactData> contacts) {
		this.contacts = new SortedListOf<ContactData>(contacts);
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
	}

	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);
		return this;
		
	}

	
}
