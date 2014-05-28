package com.example.fw;

import java.awt.List;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBaseTestNG;

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
		if (driver.findElements(By.xpath("//input[@name=\"selected\"]")).size() == 0){			
			}    //do nothing
		else{
			selectGroupByIndex(index);
			click(By.name("delete"));
		}
		
	}

	private void selectGroupByIndex(int index) {
		if (driver.findElements(By.xpath("//input[@name=\"selected\"]")).size() == 0){			
		}    //do nothing
		else{
			click(By.xpath("//input[@name='selected[]'][" + index + "]"));
		}
	}

	public void initGroupModification(int index) {
		if (driver.findElements(By.xpath("//input[@name=\"selected\"]")).size() == 0){			
		}    //do nothing
		else{
			selectGroupByIndex(index);
			click(By.name("edit"));
		}
	}

	public void submitGroupModification() {
		
		click(By.name("update"));
		
	}

}
