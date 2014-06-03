package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
	
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
	
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	public void deleteGroup(int index) {
		if (sizeFindElements("//input[@name='selected[]']") != 0){			
			selectGroupByIndex(index);
			click(By.name("delete"));
		}	
	}

	private void selectGroupByIndex(int index) {
		if (sizeFindElements("//input[@name='selected[]']") != 0){			
			click(By.xpath("//input[@name='selected[]'][" + index + "]"));
		}
		
	}

	public void initGroupModification(int index) {
		if (sizeFindElements("//input[@name='selected[]']") != 0){			
			selectGroupByIndex(index);
			click(By.name("edit"));
		}
		
	}

	private int sizeFindElements(String locator) {
		return driver.findElements(By.xpath(locator)).size();
	}

	public void submitGroupModification() {
		click(By.name("update"));	
	}

}
