package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (!onMainPage()) {
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return countElements(By.id("maintable")) > 0;
	}

	public void groupsPage() {
		if (!onGroupPage()) {
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupPage() {
		String currentURL = getCurrentUrl();
		findElements(By.name("new"));
		return (currentURL.contains("/group.php") && findElements(
				By.name("new")).size() > 0);
	}
}
