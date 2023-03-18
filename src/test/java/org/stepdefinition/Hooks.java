package org.stepdefinition;

import org.junit.AfterClass;
import org.junit.Before;
import org.mavenBaseclass.Baseclass;

public class Hooks extends Baseclass {
	@Before
	private void precondition() {
		launchBrowser();
		windowMaximize(); 

	}
	
	@AfterClass
	private void postconditioin() {
	  closeEntireBrowser();

	}

}
