package org.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.mavenBaseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmozonLogin extends Baseclass {
	
	@Given("To launch the chrome browser and maximise window")
	public void to_launch_the_chrome_browser_and_maximise_window() {
		launchBrowser();
		windowMaximize();
	    
	}

	@When("To launch the url of amazon app")
	public void to_launch_the_url_of_amazon_app() {
		launchUrl("https://www.amazon.in/");
	    
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		WebElement login = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute']"));
		login.click();
	    
	}

	@When("To pass the valid email in email field")
	public void to_pass_the_valid_email_in_email_field() throws AWTException {
		String h1 = driver.getWindowHandle();
		Set<String> h2 = driver.getWindowHandles();
		for (String win : h2) {
			if (win != h1) {
				driver.switchTo().window(win);
			}
		}
	    WebElement email = driver.findElement(By.id("ap_email"));
	    email.sendKeys("ganesh909296@gmail.com");
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("To pass the password in password field")
	public void to_pass_the_password_in_password_field() {
		
		String h1 = driver.getWindowHandle();
		Set<String> h2 = driver.getWindowHandles();
		for (String win : h2) {
			if (win != h1) {
				driver.switchTo().window(win);
			}
		}
	    WebElement pass = driver.findElement(By.id("ap_password"));
	    pass.sendKeys("ganesh0000");
	}

	@When("To click signin button")
	public void to_click_signin_button() {
		WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		
	    
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	    
	}

}
